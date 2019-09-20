from unittest import expectedFailure

from ..utils import TranspileTestCase

# class DateTimeModuleTests(TranspileTestCase):

# class DateTests(TranspileTestCase):

# class TimeDeltaTests(TranspileTestCase):

class DateTimeTests(TranspileTestCase):

    def test_creation(self):
        self.assertCodeExecution("""
            from datetime import datetime
            print(datetime(4, 10, day=11))
            print(datetime(4, 10, 11))
            print(datetime(4, month=10, day=11))
            print(datetime(year=4, month=10, day=11))
            print(datetime(14, 10, day=11))
            print(datetime(14, 10, 11))
            print(datetime(14, month=10, day=11))
            print(datetime(year=14, month=10, day=11))
            print(datetime(141, 10, day=11))
            print(datetime(141, 10, 11))
            print(datetime(141, month=10, day=11))
            print(datetime(year=141, month=10, day=11))
            print(datetime(1413, 10, day=11))
            print(datetime(1413, 10, 11))
            print(datetime(1413, month=10, day=11))
            print(datetime(year=1413, month=10, day=11))
            print(datetime(141, 11, day=11, minute=3))
            print(datetime(141, 10, 11, 5, 6, 7))
            print(datetime(141, month=10, day=11))
            print(datetime(month=10, day=11, year=141))
            print(datetime(4, 1, 1, 1, 1, 1))
            print(datetime(142, 12, day=12, second=4))
            print(datetime(142, 12, day=12, second=4, minute=2))
            """)
    
    # TODO: fix exceptions
    # def test_creation_invalid(self):
    #     self.assertCodeExecution("""
    #         from datetime import datetime
    #         try:
    #             datetime(14, month=10, 11)
    #         except SyntaxError as e:
    #             print(e)
    #         """)