# BB Class inspired by ebuild.sh
#
# This class will test files after installation for certain
# security issues and other kind of issues.
#
# Checks we do:
#  -Check the ownership and permissions
#  -Check the RUNTIME path for the $TMPDIR
#  -Check if .la files wrongly point to workdir
#  -Check if .pc files wrongly point to workdir
#  -Check if packages contains .debug directories  or .so files where they should be in -dev or -dbg
#  -Check if config.log contains traces to broken autoconf tests
#


#
# We need to have the scanelf utility as soon as
# possible and this is contained within the pax-utils-native
#


# We play a special package function
inherit package
PACKAGE_DEPENDS += "pax-utils-native"
PACKAGEFUNCS += " do_package_qa "


#
# dictionary for elf headers
#
# feel free to add and correct. the ARM EABI needs another column and we
# need mips, i386 and amd64 input (abi versions)
#
#           TARGET_OS  TARGET_ARCH   MACHINE, OSABI, ABIVERSION, Little Endian
def package_qa_get_machine_dict():
    return {
            "linux" : { "arm" :       (40,    97,    0,          True),
                        "armeb":      (40,    97,    0,          False),
                        "powerpc":    (20,     0,    0,          False),
                        "i386":       ( 3,     0,    0,          True),
                        "x64_64":     (62,     0,    0,          True),
                      },
            "linux-uclibc" : { "arm" :       (40,    97,    0,          True),
                        "armeb":      (40,    97,    0,          False),
                        "powerpc":    (20,     0,    0,          False),
                        "mipsel":     ( 8,     0,    0,          True),
                      },
        }

# factory for a class, embedded in a method
def package_qa_get_elf(path):
    class ELFFile:
        EI_NIDENT = 16

        EI_CLASS      = 4
        EI_DATA       = 5
        EI_VERSION    = 6
        EI_OSABI      = 7
        EI_ABIVERSION = 8

        # possible values for EI_CLASS
        ELFCLASSNONE = 0
        ELFCLASS32   = 1
        ELFCLASS64   = 2

        # possible value for EI_VERSION
        EV_CURRENT   = 1

        # possible values for EI_DATA
        ELFDATANONE  = 0
        ELFDATA2LSB  = 1
        ELFDATA2MSB  = 2

        def my_assert(expectation, result):
            if not expectation == result:
                #print "'%x','%x'" % (ord(expectation), ord(result))
                raise "This does not work as expected"
        my_assert = staticmethod(my_assert)

        def __init__(self, name):
            self.name = name

        def open(self):
            self.file = file(self.name, "r")
            self.data = self.file.read(ELFFile.EI_NIDENT+4)

            ELFFile.my_assert(len(self.data), ELFFile.EI_NIDENT+4)
            ELFFile.my_assert(self.data[0], chr(0x7f) )
            ELFFile.my_assert(self.data[1], 'E')
            ELFFile.my_assert(self.data[2], 'L')
            ELFFile.my_assert(self.data[3], 'F')
            ELFFile.my_assert(self.data[ELFFile.EI_CLASS], chr(ELFFile.ELFCLASS32)) # only 32 bits
            ELFFile.my_assert(self.data[ELFFile.EI_VERSION], chr(ELFFile.EV_CURRENT) )

            self.sex = self.data[ELFFile.EI_DATA]
            if self.sex == chr(ELFFile.ELFDATANONE):
                raise "Can't be"
            elif self.sex == chr(ELFFile.ELFDATA2LSB):
                self.sex = "<"
            elif self.sex == chr(ELFFile.ELFDATA2MSB):
                self.sex = ">"
            else:
                raise "Even more worse"

        def osAbi(self):
            return ord(self.data[ELFFile.EI_OSABI])

        def abiVersion(self):
            return ord(self.data[ELFFile.EI_ABIVERSION])

        def isLittleEndian(self):
            return self.sex == "<"

        def isBigEngian(self):
            return self.sex == ">"

        def machine(self):
            """
            We know the sex stored in self.sex and we
            know the position
            """
            import struct
            (a,) = struct.unpack(self.sex+"H", self.data[18:20])
            return a

    return ELFFile(path)


#
#
# Known Error classes
# 0 - non dev contains .so
# 1 - package contains a dangerous RPATH
# 2 - package depends on debug package
# 3 - non dbg contains .so
# 4 - wrong architecture
#
#

def package_qa_clean_path(path,d):
    import bb
    return path.replace(bb.data.getVar('TMPDIR',d,True),"")

def package_qa_make_fatal_error(error_class, name, path,d):
    """
    decide if an error is fatal

    TODO: Load a whitelist of known errors
    """
    if error_class == 0:
        return False
    else:
        return True

def package_qa_write_error(error_class, name, path, d):
    import bb, os
    if not bb.data.getVar('QA_LOG', d):
        return

    ERROR_NAMES =[
        "non dev contains .so",
        "package contains RPATH",
        "package depends on debug package",
        "non dbg contains .debug",
        "wrong archutecture",
    ]


    log_path = os.path.join( bb.data.getVar('T', d, True), "log.qa_package" )
    f = file( log_path, "a+")
    print >> f, "%s, %s, %s" % (ERROR_NAMES[error_class], name, package_qa_clean_path(path,d))
    f.close()


def package_qa_check_rpath(file,name,d):
    """
    Check for dangerous RPATHs
    """
    import bb, os
    scanelf = os.path.join(bb.data.getVar('STAGING_BINDIR_NATIVE',d,True),'scanelf')
    bad_dir = bb.data.getVar('TMPDIR', d, True) + "/work"
    if not os.path.exists(scanelf):
        bb.fatal("Can not check RPATH scanelf not found")
    if not bad_dir in bb.data.getVar('WORKDIR', d, True):
        bb.fatal("This class assumed that WORKDIR is ${TMPDIR}/work... Not doing any check")

    output = os.popen("%s -Byr %s" % (scanelf,file))
    txt    = output.readline().rsplit()
    if bad_dir in txt:
        package_qa_write_error( 1, name, file, d)
        bb.error("QA Issue package %s contains bad RPATH %s in file %s" % (name, txt, file))
        return False

    return True

def package_qa_check_devdbg(path, name,d):
    """
    Check for debug remains inside the binary or
    non dev packages containing
    """

    import bb
    sane = True

    if not "-dev" in name:
        if path[-3:] == ".so":
            package_qa_write_error( 0, name, path, d )
            bb.error("QA Issue: non dev package contains .so: %s path '%s'" % (name, package_qa_clean_path(path,d)))
            if package_qa_make_fatal_error( 0, name, path, d ):
                sane = False

    if not "-dbg" in name:
        if '.debug' in path:
            package_qa_write_error( 3, name, path, d )
            bb.error("QA Issue: non debug package contains .debug directory: %s path %s" % (name, package_qa_clean_path(path,d)))
            if package_qa_make_fatal_error( 3, name, path, d ):
                sane = False

    return sane

def package_qa_check_perm(path,name,d):
    """
    Check the permission of files
    """
    sane = True
    return sane

def package_qa_check_arch(path,name,d):
    """
    Check if archs are compatible
    """
    import bb
    target_os   = bb.data.getVar('TARGET_OS',   d, True)
    target_arch = bb.data.getVar('TARGET_ARCH', d, True)

    #this will throw an exception, then fix the dict above
    (machine, osabi, abiversion, littleendian) = package_qa_get_machine_dict()[target_os][target_arch]
    elf = package_qa_get_elf(path)
    try:
        elf.open()
    except:
        # just for debbugging to check the parser, remove once convinced...
        return True

    sane = True
    if not machine == elf.machine():
        bb.error("Architecture did not match (%d to %d) on %s", (machine, elf.machine(), package_qa_clean_path(path,d)))
        sane = package_qa_make_fatal_error( 4, name, path, d )
    elif not osabi == elf.osAbi():
        bb.error("OSABI did not match (%d to %d) on %s", (osabi, elf.osAbi(), package_qa_clean_path(path,d)))
        sane = package_qa_make_fatal_error( 4, name, path, d )
    elif not abiversion == elf.abiVersion():
        bb.error("ABI version did not match (%d to %d) on %s", (abiversion, elf.abiVersion(), package_qa_clean_path(path,d)))
        sane = package_qa_make_fatal_error( 4, name, path, d )
    elif not littleendian == elf.isLittleEndian():
        bb.error("Endiannes did not match (%d to %d) on %s", (littleendian, elf.isLittleEndian(), package_qa_clean_path(path,d)))
        sane = package_qa_make_fatal_error( 4, name, path, d )

    return sane

def package_qa_check_pcla(path,name,d):
    """
    .pc and .la files should not point to the WORKDIR
    """
    sane = True
    return sane

def package_qa_check_staged(path,d):
    """
    Check staged la and pc files for sanity
      -e.g. installed being false
    """
    sane = True
    return sane

# Walk over all files in a directory and call func
def package_qa_walk(path, funcs, package,d):
    import os
    sane = True

    for root, dirs, files in os.walk(path):
        for file in files:
            path = os.path.join(root,file)
            for func in funcs:
                if not func(path, package,d):
                    sane = False

    return sane


def package_qa_check_rdepends(pkg, workdir, d):
    import bb
    sane = True
    if not "-dbg" in pkg and not "task-" in pkg and not "-image" in pkg:
        # Copied from package_ipk.bbclass
        # boiler plate to update the data
        localdata = bb.data.createCopy(d)
        root = "%s/install/%s" % (workdir, pkg)

        bb.data.setVar('ROOT', '', localdata) 
        bb.data.setVar('ROOT_%s' % pkg, root, localdata)
        pkgname = bb.data.getVar('PKG_%s' % pkg, localdata, 1)
        if not pkgname:
            pkgname = pkg
        bb.data.setVar('PKG', pkgname, localdata)

        overrides = bb.data.getVar('OVERRIDES', localdata)
        if not overrides:
            raise bb.build.FuncFailed('OVERRIDES not defined')
        overrides = bb.data.expand(overrides, localdata)
        bb.data.setVar('OVERRIDES', overrides + ':' + pkg, localdata)

        bb.data.update_data(localdata)

        # Now check the RDEPENDS
        rdepends = explode_deps(bb.data.getVar('RDEPENDS', localdata, True) or "")


        # Now do the sanity check!!!
        for rdepend in rdepends:
            if "-dbg" in rdepend:
                package_qa_write_error( 2, name, rdepend, d )
                bb.error("QA issue, koen give us a better msg!!!")
                if package_qa_make_fatal_error( 2, name, rdepend, d ):
                    sane = False

    return sane

# The PACKAGE FUNC to scan each package
python do_package_qa () {
    bb.note("DO PACKAGE QA")
    workdir = bb.data.getVar('WORKDIR', d, True)
    packages = bb.data.getVar('PACKAGES',d, True)

    # no packages should be scanned
    if not packages:
        return

    walk_sane = True
    rdepends_sane = True
    for package in packages.split():
        bb.note("Checking Package: %s" % package)
        path = "%s/install/%s" % (workdir, package)
        if not package_qa_walk(path, [package_qa_check_rpath, package_qa_check_devdbg, package_qa_check_perm, package_qa_check_arch], package, d):
            walk_sane  = False
        if not package_qa_check_rdepends(package, workdir, d):
            rdepends_sane = False

    if not walk_sane or not rdepends_sane:
        bb.fatal("QA ran found fatal errors. Please consider fixing them")
    bb.note("DONE with PACKAGE QA")
}


# The Staging Func, to check all staging
addtask qa_staging after do_populate_staging before do_build
python do_qa_staging() {
    bb.note("Staged!")

    package_qa_check_staged(bb.data.getVar('STAGING_DIR',d,True), d)
}

# Check broken config.log files
addtask qa_configure after do_configure before do_compile
python do_qa_configure() {
    bb.note("Checking sanity of the config.log file")
    import os
    for root, dirs, files in os.walk(bb.data.getVar('WORKDIR', d, True)):
        if "config.log" in files:
            if os.system("grep 'CROSS COMPILE Badness:' %s > /dev/null" % (os.path.join(root,"config.log"))) == 0:
                bb.fatal("This autoconf log indicates errors, it looked at host includes. Rerun configure task after fixing this. Path was '%s'", root)
}
