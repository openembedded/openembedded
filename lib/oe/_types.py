import re

class OEList(list):
    name = "list"

    def __init__(self, value, separator = None):
        if value is not None:
            list.__init__(self, value.split(separator))
        else:
            list.__init__(self)

        if separator is None:
            self.separator = " "
        else:
            self.separator = separator

    def __str__(self):
        return self.separator.join(self)

def choice(value, choices):
    if not isinstance(value, basestring):
        raise TypeError("choice accepts a string, not '%s'" % type(value))

    value = value.lower()
    choices = choices.lower()
    if value not in choices.split():
        raise ValueError("Invalid choice '%s'.  Valid choices: %s" %
                         (value, choices))
    return value

def regex(value, regexflags=None):
    flagval = 0
    if regexflags:
        for flag in regexflags.split():
            flag = flag.upper()
            try:
                flagval |= getattr(re, flag)
            except AttributeError:
                raise ValueError("Invalid regex flag '%s'" % flag)

    try:
        return re.compile(value, flagval)
    except re.error, exc:
        raise ValueError("Invalid regex value '%s': %s" %
                         (value, exc.args[0]))

def boolean(value):
    if not isinstance(value, basestring):
        raise TypeError("boolean accepts a string, not '%s'" % type(value))

    value = value.lower()
    if value in ('yes', 'y', 'true', 't', '1'):
        return True
    elif value in ('no', 'n', 'false', 'f', '0'):
        return False
    raise ValueError("Invalid boolean value '%s'" % value)

def integer(value):
    return int(value)
