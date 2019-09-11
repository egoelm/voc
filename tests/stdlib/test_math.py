import os
import sys


from unittest import expectedFailure

from ..utils import TranspileTestCase


class MathModuleTests(TranspileTestCase):
    def test_floor(self):
        self.assertCodeExecution("""
            import math
            print(math.floor(7.35))
            print(math.floor(True))
            print(math.floor(False))
            print(math.floor(-1))
            print(math.floor(float(32.3)))
            """)
    
    @expectedFailure
    def test_ceil_expectedFailure(self):
        self.assertCodeExecution("""
            import math
            print(math.floor("string input"))
            print(math.floor([]))
            """)        
    @expectedFailure
    def test_ceil_expectedFailure2(self):
        self.assertCodeExecution("""
            import math
            print(math.floor())
            """)
