# coding:utf-8
# os.listdir(dirname)：列出dirname下的目录和文件
# os.getcwd()：获得当前工作目录
# os.curdir:返回当前目录（'.')
# os.chdir(dirname):改变工作目录到dirname
# os.path.isdir(name):判断name是不是一个目录，name不是目录就返回false
# os.path.isfile(name):判断name是不是一个文件，不存在name也返回false
# os.path.exists(name):判断是否存在文件或目录name
# os.path.getsize(name):获得文件大小，如果name是目录返回0L
# os.path.abspath(name):获得绝对路径
# os.path.normpath(path):规范path字符串形式
# os.path.split(name):分割文件名与目录（事实上，如果你完全使用目录，它也会将最后一个目录作为文件名而分离，同时它不会判断文件或目录是否存在）
# os.path.splitext():分离文件名与扩展名
# os.path.join(path,name):连接目录与文件名或目录
# os.path.basename(path):返回文件名
# os.path.dirname(path):返回文件路径
# os.remove(dir) #dir为要删除的文件夹或者文件路径
# os.rmdir(path) #path要删除的目录的路径。需要说明的是，使用os.rmdir删除的目录必须为空目录，否则函数出错。
# os.path.getmtime(name) ＃获取文件的修改时间
# os.stat(path).st_mtime＃获取文件的修改时间
# os.stat(path).st_ctime #获取文件修改时间
# os.path.getctime(name)#获取文件的创建时间

import os, datetime

dirToBeEmptied = "C:\\Windows\\System32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\application_interface_test\html1"


ds = list(os.walk(dirToBeEmptied)) #获得所有文件夹的信息列表
delta = datetime.timedelta(days=3) #设定365天前的文件为过期
now = datetime.datetime.now() #获取当前时间
# print ds
# print delta
# print now

for d in ds: #遍历该列表
    os.chdir(d[0]) #进入本级路径，防止找不到文件而报错
    if d[2] != []: #如果该路径下有文件
        for x in d[2]: #遍历这些文件
            ctime = datetime.datetime.fromtimestamp(os.path.getctime(x)) #获取文件创建时间
            print ctime
            print x
            if ctime < (now-delta): #若创建于delta天前
                os.remove(x) #则删掉