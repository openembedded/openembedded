def is_optional(group, d):
    return bool(d.getVarFlag("PACKAGE_GROUP_%s" % group, "optional"))

def packages(groups, d):
    from itertools import chain
    return chain.from_iterable(d.getVar("PACKAGE_GROUP_%s" % group, True).split()
                               for group in groups)

def required_packages(groups, d):
    req = filter(lambda group: not is_optional(group, d), groups)
    return " ".join(packages(req, d))

def optional_packages(groups, d):
    opt = filter(lambda group: is_optional(group, d), groups)
    return " ".join(packages(opt, d))
