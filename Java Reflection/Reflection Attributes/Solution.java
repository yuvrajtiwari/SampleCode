public class Solution {

        public static void main(String[] args){
         try{

                Class student = Class.forName("Student");
                
                Method[] methods = student.getDeclaredMethods();
               
                ArrayList<String> methodList = new ArrayList<String>();
                for(Method m : methods){
               
                    methodList.add(m.getName());
               
                }
                Collections.sort(methodList);
                for(String name: methodList){
                    System.out.println(name);
                }
            }
            catch(ClassNotFoundException e){
                e.printStackTrace() ;
            }
        }

    }
