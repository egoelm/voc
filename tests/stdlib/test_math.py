from unittest import expectedFailure

from ..utils import TranspileTestCase



class MathModuleTests(TranspileTestCase):
    def test_ceil(self):
        self.assertCodeExecution("""
            import math
            print(math.ceil(4.5))
            print(math.ceil(True))
            print(math.ceil(False))
            print(math.ceil(-1))
            """)
    
    @expectedFailure
    def test_ceil_expectedFailure(self):
        self.assertCodeExecution("""
            import math
            print(math.ceil("hej"))
            print(math.ceil([]))
            """)        


