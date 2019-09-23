from unittest import expectedFailure

from ..utils import TranspileTestCase

# class DateTimeModuleTests(TranspileTestCase):

# class TimeDeltaTests(TranspileTestCase):

#class DateTimeTests(TranspileTestCase):
    #######################################################
    # __file__


    #######################################################

    #def test_creation(self):
    #    self.assertCodeExecution("""
    #        from datetime import datetime
    #        print(datetime(4, 10, day=11))
    #        print(datetime(4, 10, 11))
    #        print(datetime(4, month=10, day=11))
    #        print(datetime(year=4, month=10, day=11))
    #        print(datetime(14, 10, day=11))
    #        print(datetime(14, 10, 11))
    #        print(datetime(14, month=10, day=11))
    #        print(datetime(year=14, month=10, day=11))
    #        print(datetime(141, 10, day=11))
    #        print(datetime(141, 10, 11))
    #        print(datetime(141, month=10, day=11))
    #        print(datetime(year=141, month=10, day=11))
    #        print(datetime(1413, 10, day=11))
    #        print(datetime(1413, 10, 11))
    #        print(datetime(1413, month=10, day=11))
    #        print(datetime(year=1413, month=10, day=11))""")
    #
    #######################################################

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


class DateTests(TranspileTestCase):
    #######################################################
    #######################################################
    # __file__
    #@expectedFailure
    def test___repr__(self):
        self.assertCodeExecution("""
            from datetime import date
            print(date.__repr__)
            """)

    #######################################################


    #######################################################

    def test_creation(self):
        self.assertCodeExecution("""
            from datetime import date
            print(date(14, 10, day=11))
            print(date(14, 10, 11))
            print(date(14, month=10, day=11))
            print(date(year=14, month=10, day=11))""")
