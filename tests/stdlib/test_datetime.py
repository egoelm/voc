from unittest import expectedFailure

from ..utils import TranspileTestCase

# class DateTimeModuleTests(TranspileTestCase):

# class DateTests(TranspileTestCase):

# class TimeDeltaTests(TranspileTestCase):

class DateTimeTests(TranspileTestCase):

    def test_creation(self):
        self.assertCodeExecution("""
            from datetime import datetime
            print(datetime(14, 10, day=11))
            print(datetime(14, 10, 11))
            print(datetime(14, month=10, day=11))
            print(datetime(year=14, month=10, day=11))
            """)
    
    # def test_creation_invalid(self):
    #     self.assertCodeExecution("""
    #         from datetime import datetime
    #         try:
    #             datetime(14, month=10, 11)
    #         except SyntaxError as e:
    #             print(e)

    #         try:
    #             datetime(year=14, month=10, 11)
    #         except SyntaxError as e:
    #             print(e)

    #         try:
    #             datetime(year=14, 10, day=11)
    #         except SyntaxError as e:
    #             print(e)
            
    #         try:
    #             datetime(year=14, 10, 11)
    #         except SyntaxError as e:
    #             print
    #         """)