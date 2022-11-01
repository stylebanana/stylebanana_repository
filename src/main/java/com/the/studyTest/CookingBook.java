package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CookingBook{

    public static class Recipe{
        //名称
        private String name;
        //烹饪步骤数量
        private int numberOfInstructions;
        //材料数量
        private int numberOfIngredients;
        //烹饪步骤
        private String[] instructions;
        //配方数组
        private String[] ingredients;

        public Recipe(){
        }

        public Recipe(String name,String[] instructions,int numberOfInstructions,String[] ingredients,int numberOfIngredients){
            this.name = name;
            this.instructions = instructions;
            this.numberOfInstructions = numberOfInstructions;
            this.ingredients = ingredients;
            this.numberOfIngredients = numberOfIngredients;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumberOfInstructions() {
            return numberOfInstructions;
        }

        public void setNumberOfInstructions(int numberOfInstructions) {
            this.numberOfInstructions = numberOfInstructions;
        }

        public int getNumberOfIngredients() {
            return numberOfIngredients;
        }

        public void setNumberOfIngredients(int numberOfIngredients) {
            this.numberOfIngredients = numberOfIngredients;
        }

        public String[] getInstructions() {
            return instructions;
        }

        public void setInstructions(String[] instructions) {
            this.instructions = instructions;
        }

        public String[] getIngredients() {
            return ingredients;
        }

        public void setIngredients(String[] ingredients) {
            this.ingredients = ingredients;
        }

        @Override
        public String toString() {
            return "Recipe{" +
                    "食谱名称='" + name + '\'' +
                    ", instructions=" + Arrays.toString(instructions) +
                    ", numberOfInstructions=" + numberOfInstructions +
                    ", ingredients=" + Arrays.toString(ingredients) +
                    ", numberOfIngredients=" + numberOfIngredients +
                    '}';
        }

    }

    public class Cookbook{

        //食谱recipe的对象的arraylist数组列表,(相当于目录)
        private Recipe[] listOfRecipes;

        //表示食谱数量的int
        private int numberOfRecipes; 


        public Recipe[] getListOfRecipes() {
            return listOfRecipes;
        }


        public void setListOfRecipes(Recipe[] listOfRecipes) {
            this.listOfRecipes = listOfRecipes;
        }


        public int getNumberOfRecipes() {
            return numberOfRecipes;
        }


        public void setNumberOfRecipes(int numberOfRecipes) {
            this.numberOfRecipes = numberOfRecipes;
        }


        //添加菜谱方法
        public void addRecipe (Recipe r){
            if (this.listOfRecipes == null){
                //如果listOfRecipes是空的话，在set方法中new一个Recipe[]将这个数组类型的{r}放进数组里面去
                setListOfRecipes(new Recipe[]{r});
                //对书谱的数量进行赋值
                setNumberOfRecipes(1);
            }else{
                this.numberOfRecipes++;
                this.listOfRecipes = sortByName(this.listOfRecipes,r);
            }
        }   

        //排序的方法
        public Recipe[] sortByName(Recipe[] listOfRecipes,Recipe r){

            if (listOfRecipes == null || listOfRecipes.length == 0){
                return null;
            }
            //如果已经有了listofRecipes,再加进去一个Recipe,那么加进去的数组的长度就要加大1
            Recipe[] sortArray = new Recipe[listOfRecipes.length+1];
            int index = 0;
            Boolean addFlag = false;
            //找到固定的位置(比较的结果<0),做插入
            for(int i=0; i<listOfRecipes.length; i++){
                String name = r.getName();
                String nextName = listOfRecipes[i].getName();
                if(name.compareTo(nextName)<0){
                    sortArray[index] = r;
                    index++;
                    //定位以后的位置按照原来顺序接着放去新的数组中去
                    for(int otherIndex = i; otherIndex<listOfRecipes.length; otherIndex++){
                        sortArray[index]=listOfRecipes[otherIndex];
                        index++;
                    }
                    addFlag=true;
                    break;
                }else{
                    //还没到定位位置，顺序和原来一样；
                    sortArray[index]=listOfRecipes[i];
                }
                index++;
            }
            return sortArray;
        }
    }
}