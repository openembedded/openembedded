import unittest
from oe.maketype import create, factory

class TestTypes(unittest.TestCase):
    def assertIsInstance(self, obj, cls):
        return self.assertTrue(isinstance(obj, cls))

    def assertIsNot(self, obj, other):
        return self.assertFalse(obj is other)

    def assertFactoryCreated(self, value, type, **flags):
        obj = factory(type)
        self.assertIsNot(obj, None)
        self.assertIsInstance(create(value, type, **flags), obj)

class TestBooleanType(TestTypes):
    def test_boolean(self):
        self.assertRaises(ValueError, create, '', 'boolean')
        self.assertRaises(ValueError, create, 'foo', 'boolean')
        self.assertRaises(TypeError, create, object(), 'boolean')

    def test_boolean_true(self):
        self.assertEqual(create('y', 'boolean'), True)
        self.assertEqual(create('yes', 'boolean'), True)
        self.assertEqual(create('1', 'boolean'), True)
        self.assertEqual(create('t', 'boolean'), True)
        self.assertEqual(create('true', 'boolean'), True)
        self.assertEqual(create('TRUE', 'boolean'), True)
        self.assertEqual(create('truE', 'boolean'), True)

    def test_boolean_false(self):
        self.assertEqual(create('n', 'boolean'), False)
        self.assertEqual(create('no', 'boolean'), False)
        self.assertEqual(create('0', 'boolean'), False)
        self.assertEqual(create('f', 'boolean'), False)
        self.assertEqual(create('false', 'boolean'), False)
        self.assertEqual(create('FALSE', 'boolean'), False)
        self.assertEqual(create('faLse', 'boolean'), False)

class TestList(TestTypes):
    def assertListEqual(self, value, valid, sep=None):
        obj = create(value, 'list', separator=sep)
        self.assertEqual(obj, valid)
        if sep is not None:
            self.assertEqual(obj.separator, sep)
        self.assertEqual(str(obj), obj.separator.join(obj))

    def test_list_nosep(self):
        testlist = ['alpha', 'beta', 'theta']
        self.assertListEqual('alpha beta theta', testlist)
        self.assertListEqual('alpha  beta\ttheta', testlist)
        self.assertListEqual('alpha', ['alpha'])

    def test_list_usersep(self):
        self.assertListEqual('foo:bar', ['foo', 'bar'], ':')
        self.assertListEqual('foo:bar:baz', ['foo', 'bar', 'baz'], ':')
