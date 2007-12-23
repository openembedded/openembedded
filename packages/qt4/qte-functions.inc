def qte_arch(d):
        import bb, re
        arch = bb.data.getVar('TARGET_ARCH', d, 1)
        if re.match("^i.86$", arch):
                arch = "x86"
        elif arch == "x86_64":
                arch = "x86"
        elif arch == "mipsel":
                arch = "mips"
        return arch

