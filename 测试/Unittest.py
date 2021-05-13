# 创建人：郭雨龙
# 创建时间：2021/5/5 21:33
import unittest
"""该章阐述了Python自带的unittest库的基本用法"""
"""被测试的代码"""
def fun1(Xing,Ming):
    full_name=f"{Xing} {Ming}"
    return full_name.title()

# 测试方法，继承了unittest.Testcase
class fun1_test(unittest.TestCase):
    # 该文件执行时，所有的test_开头的方法都会被自动执行
    def test_fun1(self):
        format_name=fun1("guo","yulong")
        self.assertEqual(format_name,"Guo Yulong")
    # unittest的六种断言类
    def test_6casefun(self):
        self.assertNotEqual()
        self.assertTrue()
        self.assertFalse()
        self.assertIn()
        self.assertnotIn()

class AnonymousSurvey:
    question = "你喜欢谁?"
    request = input(question)

class TestAnonymousSurvey(unittest.TestCase):
    def setUp(self):
        

# __name__变量是一个特殊变量，在程序执行时设置
# 如果这个文件作为主程序执行，变量__name__将被设置为’__main__'。
# 即载入时不执行
if __name__=='__main__':
    unittest.main()
