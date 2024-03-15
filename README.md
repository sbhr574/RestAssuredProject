# RestAssuredProject
Rest Assured Automation for Practice Purpose

Steps to add existing project to github
1. Create a repo with same name of the project.
2. Open git bash from system and run 'git init'
3. Next command is 'git add .'
4. Next is commit the files 'git commit -m "Initial commit"'
5. Next mention the repo SSH path 'git remote add origin git@github.com:sbhr574/RestAssuredProject.git'
6. If we are using SSH from git setting need to create new key for git hub.
7. Run 'ssh-keygen -t rsa -b 4096 -C "******@gmail.com"'. For more refere "https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent"
8. Run 'cat path' and get the key. path should be like this(ex: /c/Users/*****/id_rsa.pub)
9. Title can be any meaning full name. Paste the key and click on "Add SSH Key" button.
![image](https://user-images.githubusercontent.com/34245876/214477114-9b5c201c-dc44-46da-8d32-31277317b7be.png)


HTTP Status code:-
Refer - https://www.youtube.com/watch?v=zisAGm5I-Yw&list=PLUDwpEzHYYLuW9XEvFEJk2kqsk6HqscI4&index=2
time 1:06 
There are 3 levels or series present in REST API. Those are 200, 400 and 500.
![image](https://github.com/sbhr574/RestAssuredProject/assets/34245876/4e6d4282-d50e-4512-b325-cc1aeb6e34cb)
200 - This status code level represents the request is successfully done.
400 - This represents the unauthorized access of the API. 
500 - When sending the request to the server and facing some problem with the network or server problem. 

