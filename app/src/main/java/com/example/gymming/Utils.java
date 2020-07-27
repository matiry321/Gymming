package com.example.gymming;

import java.util.ArrayList;

public class Utils {
    private static ArrayList<Modelclass> exercises;
    private static ArrayList<Plan> plans;

    public Utils() {
        if(null==plans)
        {
            plans=new ArrayList<>();
        }

    }

    public static void initTrainings()
    {
        if(null==exercises)
        {
            exercises=new ArrayList<>();
        }
        Modelclass pushup = new Modelclass(1,"Push Up","Pushups are a fast and effective exercise for building strength. They can be done from virtually anywhere and don’t require any equipment"
        ,"Traditional pushups are beneficial for building upper body strength. They work the triceps, pectoral muscles, and shoulders. When done with proper form, they can also strengthen the lower back and core by engaging (pulling in) the abdominal muscles"
        ,"https://media.self.com/photos/59a9958453ab243f663b2e77/master/pass/pic5.jpg");
        exercises.add(pushup);

        Modelclass cycling = new Modelclass(2,"Cycling","Riding a stationary exercise bike is an efficient and effective way to burn calories and body fat while strengthening your heart, lungs, and muscles",
                " Indoor cycling is an organized activity with a group fitness format. Classes focus on endurance, strength, interval, and high intensity training using the stationary bike. The indoor cycle that evolved from the stationary bike is designed with a heavy weighted flywheel, chain drive, and friction resistance offering an experience similar to that of a road bike",
                "https://i.insider.com/5e00f3c1855cc264c9388e92?width=1100&format=jpeg&auto=webp");
        exercises.add(cycling);

        Modelclass treadmill= new Modelclass(3,"Treadmill","A treadmill is a device generally for walking, running or climbing while staying in the same place","There are almost countless health benefits to regular exercise, including heart strength, weight loss, and decreased insulin resistance. Walking or running on a treadmill is an excellent source of exercise that puts less stress on the body than walking or running on a flat surface outdoors","" +
                "https://lifehacker.co.in/wp-content/uploads/2019/10/71F3cjFt4OL._SL1500_-1024x1024.jpg");
        exercises.add(treadmill);

        Modelclass inclined = new Modelclass(4,"Incline Bench Press","The Incline Bench Press is a version of the traditional Bench Press in which the bench is positioned at about a 45-degree angle"
        ,"The incline bench press is a variation of the bench press and an exercise used to build the muscles of the chest,Utilizing an incline will allow you to better target the upper portion of the chest, a lagging part for a lot of lifters",
                "https://cdn.totalworkout.fitness/160725/exercise/1280/frame/10101.2.jpg");
        exercises.add(inclined);

        Modelclass lunge = new Modelclass(5,"Lunge","a sudden forward thrust of the body, typically with an arm outstretched to attack someone or seize something",
                "Lunges can help you develop lower-body strength and endurance. They’re also a great beginner move. When done correctly, lunges can effectively target your lower-body muscles without placing added strain on your joints" ,"https://media1.popsugar-assets.com/files/thumbor/XBjqBbublGCisq8WJ589r9Ljlws/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2018/12/28/137/n/1922729/tmp_1KPWA3_4a8efb52e5e289b7_PS17_0001_GetFit_Fitness_Workout_0738.jpg");
        exercises.add(lunge);

        Modelclass russian = new Modelclass(6,"Russian Twist","The Russian twist is a simple and effective way to tone your core, shoulders, and hips","If you don’t have a weight, grab a compact household object that’s at least five pounds. Choose a weight that allows you to maintain proper form.\n" +
                "Hold a dumbbell, weight plate, or medicine ball between both hands","https://cdn1.coachmag.co.uk/sites/coachmag/files/styles/insert_main_wide_image/public/2018/10/weighted-russian-twist.jpg?itok=DvEA9w23");
        exercises.add(russian);


    }

    public static ArrayList<Modelclass> getExercises() {
        return exercises;
    }

   public static boolean addPlan(Plan plan)
    {
        if(null!=plans)
        {
            plans=new ArrayList<>();
        }
        return plans.add(plan);
    }
    public static ArrayList<Plan> getPlans()
    {
        return plans;
    }
    public static boolean removePlans(Plan plan)
    {
        return plans.remove(plan);
    }
    /*public boolean addPlan(Plan plan)
    {
        return plans.add(plan);
    }*/
}
