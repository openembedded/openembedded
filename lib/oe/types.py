# Constructs objects of the specified type for a given variable in the
# metadata.  The 'type' flag of the variable defines which of the factory
# functions in this module will be called.
#
# If no type is defined, the value() function will simply return the expanded
# string value as is.

import bb
import inspect
import _types

types = {}

class MissingFlag(TypeError):
    def __init__(self, flag, type):
        self.flag = flag
        self.type = type
        TypeError.__init__(self)

    def __str__(self):
        return "Type '%s' requires flag '%s'" % (self.type, self.flag)

def factory(var_type):
    try:
        return types[var_type]
    except KeyError:
        raise TypeError("Invalid type '%s'" % var_type)

def create(value, var_type, **flags):
    obj = factory(var_type)
    objflags = {}
    for flag in obj.flags:
        if flag not in flags:
            if flag not in obj.optflags:
                raise MissingFlag(flag, var_type)
        else:
            objflags[flag] = flags[flag]

    return obj(value, **objflags)

def value(key, d):
    """Construct a value for a metadata variable, based upon its flags"""

    var_type = d.getVarFlag(key, 'type')
    flags = d.getVarFlags(key)

    try:
        return create(d.getVar(key, True) or '', var_type, **flags)
    except (TypeError, ValueError), exc:
        bb.fatal("%s: %s" % (key, str(exc)))

def get_callable_args(obj):
    """Grab all but the first argument of the specified callable, returning
    the list, as well as a list of which of the arguments have default
    values."""
    if type(obj) is type:
        obj = obj.__init__

    args, varargs, keywords, defaults = inspect.getargspec(obj)
    flaglist = []
    if args:
        if len(args) > 1 and args[0] == 'self':
            args = args[1:]
        flaglist.extend(args)

    optional = set()
    if defaults:
        optional |= set(flaglist[-len(defaults):])
    return flaglist, optional

def factory_setup(name, obj):
    """Prepare a factory for use by oe.types"""
    args, optional = get_callable_args(obj)
    extra_args = args[1:]
    if extra_args:
        obj.flags, optional = extra_args, optional
        obj.optflags = set(optional)
    else:
        obj.flags = obj.optflags = ()

    if not hasattr(obj, 'name'):
        obj.name = name

def register(name, factory):
    factory_setup(name, factory)
    types[factory.name] = factory

# Set the 'flags' and 'optflags' attributes of all our types
for name in dir(_types):
    if name.startswith('_'):
        continue

    obj = getattr(_types, name)
    if not callable(obj):
        continue

    register(name, obj)
