def read_available(filename):
    """
    Parses the output of bitbake -s
    minus the first few lines
    """
    f = open(filename)
    packages = {}

    for line in f:
        if line.startswith("NOTE: ") or line.startswith("Parsing .bb") or line.startswith("done."):
            continue

        # str.split can not be used as we have multiple whitespace
        split = line.split(" ", 1)
        package = split[0]
        rest = split[1].strip()

        # we might have a latest package...
        split = rest.split(" ", 1)
        if len(split) == 2:
            version = split[1].strip()
        else:
            version = split[0]

        packages[package] = version
    return packages


