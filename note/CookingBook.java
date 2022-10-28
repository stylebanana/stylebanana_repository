package com.example.demo;

import java.util.ArrayList;

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

    }

    public class Cookbook{

        //食谱recipe的对象的arraylist数组列表,(相当于目录)
        private Recipe[] listOfRecipes;

        //表示食谱数量的int
        private int numberOfRecipes; 

        public void addRecipe (Recipe r){
            if (this.listOfRecipes == null){
                setListOfRecipes(new Recipe[]{r});
                setNumberOfRecipes(1);
            }
            }

        private void setNumberOfRecipes(int numberOfRecipes) {
            this.numberOfRecipes = numberOfRecipes;
        }

        private void setListOfRecipes(Recipe[] listofRecipes) {
            this.listOfRecipes = listOfRecipes;
        }

        

    }
}