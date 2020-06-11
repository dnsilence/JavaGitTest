####  Git学习

+ **地址**

  - 廖雪峰官方学习网站：https://www.liaoxuefeng.com/wiki/896043488029600
  - 《Pro git》

+ **笔记**

  + 分布式版本控制系统

  + 安装：

    + 配置

      ```git
      $ git config --global user.name "Your Name"
      $ git config --global user.email "email@example.com"
      ```

    + global :默认本地所有git仓库均使用设置的配置

  + 新手不要修改.git目录，会破坏仓库

  + Windows中不要用记事本编辑任何文本文件

  + 提交文件分两步：git add（暂存） + git commit（提交）

  + 配置ssh密钥，将本地对公密钥配置到GitHub中

  + 关联远程库 origin 

    ```git
    $ git remote add origin git@github.com:michaelliao/learngit.git
    ```

   + git push 将本地仓库上传到GitHub中

     ```
     $ git push origin master
     ```

   + 分支

     + clone仓库至本地

     + 添加分支并维护

       ```git
       $ git branch "branch name"
       ```

     + 关联远程库(同前)

     + push 分支至远程库

       ```
       初次：$ git push --set-upstream origin "branch name"
       多次：$ git push origin "branch name"
       ```



