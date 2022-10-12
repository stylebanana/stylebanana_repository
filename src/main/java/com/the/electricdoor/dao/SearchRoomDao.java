package com.the.electricdoor.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.the.electricdoor.Entity.SearchRoom;

@Component
public class SearchRoomDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public SearchRoom selectSearchRoombyhotel_id(String hotel_id) {
        //从顾客前段写入的‘房间’表里抽取目标房间；
        int tatami_rooms;
        int western_rooms;
        int has_dining;
        int has_kitchen;
        int has_aircondition;

        StringBuffer sql = new StringBuffer();

        //sql.append("select * from room where 1=1");

        if(tatami_rooms!=0){
            sql.append(" and tatami_rooms = ").append(tatami_rooms);
        }

        if(western_rooms!=0){
            sql.append(" and western_rooms = ").append(western_rooms);
        }

        if(has_dining!=0){
            sql.append(" and has_dining = ").append(has_dining);
        }

        if(has_kitchen!=0){
            sql.append(" and has_kitchen = ").append(has_kitchen);
        }

        if(has_aircondition!=0){
            sql.append(" ans has_aircondition = ").append(has_aircondition);
        }

        //检索房间的条件返回给service层；将mysql返回的数据包装成自定义的范型；
        
        List<SearchRoom> rs = jdbcTemplate.query(sql, 
        new RowMapper<SearchRoom>(){
            @Override
            public SearchRoom mapRow(ResultSet arg0,int arg1) throws SQLException{
                SearchRoom searchRoom = new SearchRoom();
                searchRoom.setTatami_rooms(arg0.tatami_rooms);
                searchRoom.setwestern_rooms(arg0.western_rooms);
                searchRoom.setHas_dining(arg0.has_dining);
                searchRoom.setHas_kitchen(arg0.has_dining);
                searchRoom.setHas_aircondition(arg0.has_aircondition);
                return searchRoom;
            }
        });

        SearchRoom searchRoom = null;

        if(rs.size() > 0){
            searchRoom = rs.get(0);
        }

       

        // List<SearchRoom> rs = jdbcTemplate.query(sql,
        // new RowMapper<SearchRoom>() {
		// 	@Override
		// 	public SearchRoom mapRow(ResultSet arg0, int arg1) throws SQLException {
		// 		SearchRoom searchRoom = new SearchRoom();
                
        //         searchRoom.setTatami_rooms(arg0.getTatami_rooms(tatami_rooms));
        //         acount.setAcount_password(arg0.getString("acount_password"));
        //         acount.setNick_name(arg0.getString("nick_name"));
        //         acount.setSex(arg0.getInt("sex"));
		// 		acount.setCreate_time(arg0.getDate("create_time"));
        //         return acount;
		// 	}
		// }, user_name);

        // Acount acount = null;

        // if(rs.size() > 0){
        //     acount = rs.get(0);
        // }

        // return acount;
        return searchRoom;
    }
}
