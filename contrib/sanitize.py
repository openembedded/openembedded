#!/usr/bin/env python

# sanitize a bitbake file following the OpenEmbedded style guidelines 
# see http://openembedded.org/wiki/StyleGuide 
# (C) 2006 Cyril Romain <cyril.romain@gmail.com>
# MIT license

# TODO: 
#   -  add the others OpenEmbedded variables commonly used
#   ./ handle comments in .bb files
#   -  parse command arguments and print usage on misuse
#       . prevent giving more than one .bb file in arguments
#   -  write result to a file
#   -  backup the original .bb file
#   -  make a diff and ask confirmation for patching ?
#   -  /!\ startswith('SOMETHING') is not taken into account due to the previous startswith('S').
#   -  count rule breaks and displays them in the order frequence

from odict import OrderedDict
import fileinput
import string
import re

__author__ = "Cyril Romain <cyril.romain@gmail.com>"
__version__ = "$Revision: 0.3 $"

# The ordered list of OpenEmbedded variables
OE_vars = OrderedDict([
    ('DESCRIPTION', []),
    ('AUTHOR', []),
    ('HOMEPAGE', []),
    ('SECTION', []),
    ('PRIORITY', []),
    ('MAINTAINER', []),
    ('LICENSE', []),
    ('DEPENDS', []),
    ('RDEPENDS', []),
    ('RRECOMMENDS', []),
    ('RSUGGESTS', []),
    ('PROVIDES', []),
    ('RPROVIDES', []),
    ('RCONFLICTS', []),
    ('SRCDATE', []),
    ('PV', []),
    ('PR', []),
    ('SRC_URI', []),
    ('S', []),
    ('inherit', []),
    ('EXTRA_', []),
    ('do_fetch', []),
    ('do_unpack', []),
    ('do_patch', []),
    ('do_configure', []),
    ('do_compile', []),
    ('do_install', []),
    ('do_package', []),
    ('do_stage', []),
    ('PACKAGE_ARCH', []),
    ('PACKAGES', []),
    ('FILES', []),
    ('WORKDIR', []),
    ('acpaths', []),
    ('addhandler', []),
    ('addtask', []),
    ('bindir', []),
    ('export', []),
    ('headers', []),
    ('include', []),
    ('includedir', []),
    ('python', []),
    ('qtopiadir', []),
    ('pkg_postins', []),
    ('pkg_postrm', []),
    ('require', []),
    ('sbindir', []),
    ('basesysconfdir', []),
    ('sysconfdir', []),
    ('ALLOW_EMPTY', []),
    ('ALTERNATIVE_LINK', []),
    ('ALTERNATIVE_NAME', []),
    ('ALTERNATIVE_PATH', []),
    ('ALTERNATIVE_PRIORITY', []),
    ('ALTNAME', []),
    ('AMD_DRIVER_LABEL', []),
    ('AMD_DRIVER_VERSION', []),
    ('ANGSTROM_EXTRA_INSTALL', []),
    ('APPDESKTOP', []),
    ('APPIMAGE', []),
    ('APPNAME', []),
    ('APPTYPE', []),
    ('APPWEB_BUILD', []),
    ('APPWEB_HOST', []),
    ('AR', []),
    ('ARCH', []),
    ('ARM_INSTRUCTION_SET', []),
    ('ARM_MUTEX', []),
    ('ART_CONFIG', []),
    ('B', []),
    ('BJAM_OPTS', []),
    ('BJAM_TOOLS', []),
    ('BONOBO_HEADERS', []),
    ('BOOTSCRIPTS', []),
    ('BROKEN', []),
    ('BUILD_ALL_DEPS', []),
    ('BUILD_CPPFLAGS', []),
    ('CFLAGS', []),
    ('CCFLAGS', []),
    ('CMDLINE', []),
    ('COLLIE_MEMORY_SIZE', []),
    ('COMPATIBLE_HOST', []),
    ('COMPATIBLE_MACHINE', []),
    ('COMPILE_HERMES', []),
    ('CONFFILES', []),
    ('CONFLICTS', []),
    ('CORE_EXTRA_D', []),
    ('CORE_PACKAGES_D', []),
    ('CORE_PACKAGES_RD', []),
    ('CPPFLAGS', []),
    ('CVSDATE', []),
    ('CXXFLAGS', []),
    ('DEBIAN_NOAUTONAME', []),
    ('DEBUG_APPS', []),
    ('DEFAULT_PREFERENCE', []),
    ('DB4_CONFIG', []),
    ('EXCLUDE_FROM_SHLIBS', []),
    ('EXCLUDE_FROM_WORLD', []),
    ('FIXEDSRCDATE', []),
    ('GLIBC_ADDONS', []),
    ('GLIBC_EXTRA_OECONF', []),
    ('GNOME_VFS_HEADERS', []),
    ('GPE_TARBALL_SUFFIX', []),
    ('HEADERS', []),
    ('INHIBIT_DEFAULT_DEPS', []),
    ('INITSCRIPT_NAME', []),
    ('INITSCRIPT_PACKAGES', []),
    ('INITSCRIPT_PARAMS', []),
    ('IPKG_INSTALL', []),
    ('KERNEL_IMAGETYPE', []),
    ('KERNEL_IMAGEDEST', []),
    ('KERNEL_OUTPUT', []),
    ('KERNEL_RELEASE', []),
    ('KERNEL_PRIORITY', []),
    ('KERNEL_SOURCE', []),
    ('KERNEL_SUFFIX', []),
    ('KERNEL_VERSION', []),
    ('K_MAJOR', []),
    ('K_MICRO', []),
    ('K_MINOR', []),
    ('HHV', []),
    ('KV', []),
    ('LDFLAGS', []),
    ('LD', []),
    ('LD_SO', []),
    ('LDLIBS', []),
    ('LEAD_SONAME', []),
    ('LIBTOOL', []),
    ('LIBBDB_EXTRA', []),
    ('LIBV', []),
    ('MACHINE', []),
    ('MACHINE_ESSENTIAL_EXTRA_RDEPENDS', []),
    ('MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS', []),
    ('MACHINE_EXTRA_RDEPENDS', []),
    ('MACHINE_EXTRA_RRECOMMENDS', []),
    ('MACHINE_FEATURES', []),
    ('MACHINE_TASKS', []),
    ('MACHTYPE', []),
    ('MAKE_TARGETS', []),
    ('MESSAGEUSER', []),
    ('MESSAGEHOME', []),
    ('MIRRORS', []),
    ('MUTEX', []),
    ('OE_QMAKE_INCDIR_QT', []),
    ('OE_QMAKE_CXXFLAGS', []),
    ('ORBIT_IDL_SRC', []),
    ('PARALLEL_MAKE', []),
    ('PAKCAGE_ARCH', []),
    ('PCMCIA_MANAGER', []),
    ('PKG_BASENAME', []),
    ('QEMU', []),
    ('QMAKE_PROFILES', []),
    ('QPEDIR', []),
    ('QPF_DESCRIPTION', []),
    ('QPF_PKGPATTERN', []),
    ('QT_CONFIG_FLAGS', []),
    ('QT_LIBRARY', []),
    ('ROOTFS_POSTPROCESS_COMMAND', []),
    ('RREPLACES', []),
    ('TARGET_CFLAGS', []),
    ('TARGET_CPPFLAGS', []),
    ('TARGET_LDFLAGS', []),
    ('UBOOT_MACHINE', []),
    ('UCLIBC_BASE', []),
    ('UCLIBC_PATCHES', []),
    ('UNSLUNG_PACKAGES', []),
    ('VIRTUAL_NAME', []),
    ('XORG_PN', []),
    ('XSERVER', []),
    ('others', [])
])

varRegexp = r'^([A-Z_0-9]*)([ \t]*?)([+.:]?=[+.]?)([ \t]*?)("[^"]*["\\]?)'
routineRegexp = r'^([a-zA-Z0-9_ -]+?)\('

# Style guideline #0: No spaces are allowed at the beginning of lines that define a variable or a do_ routine
def check_rule0(line): 
    return line.lstrip()==line
def follow_rule0(line): 
    return line.lstrip()

# Style guideline #1: No spaces are allowed behind the line continuation symbol '\'
def check_rule1(line):
    if line.rstrip().endswith('\\'):
        return line.endswith('\\')
    else: 
        return True
def follow_rule1(line):
    return line.rstrip()

# Style guideline #2: Tabs should not be used (use spaces instead).
def check_rule2(line):
    return line.count('\t')==0
def follow_rule2(line):
    return line.expandtabs()

# Style guideline #3: Comments inside bb files are allowed using the '#' character at the beginning of a line.
def check_rule3(line):
    if line.lstrip().startswith('#'):
        return line.startswith('#')
    else: 
        return True
def follow_rule3(line):
    return line.lstrip()

# Style guideline #4: Use quotes on the right hand side of assignments: FOO = "BAR"
def check_rule4(line):
    return re.match(varRegexp, line) is not None
def follow_rule4(line):
    return follow_rule5(line)

# Style guideline #5: The correct spacing for a variable is FOO = "BAR".
def check_rule5(line):
    r = re.search(varRegexp, line)
    return r is not None and r.group(2)==" " and r.group(4)==" "
def follow_rule5(line):
    r = re.search(varRegexp, line)
    return ''.join([r.group(1), ' ', r.group(3), ' ', r.group(5)])

# Style guideline #6: Don't use spaces or tabs on empty lines
def check_rule6(line):
    return not line.isspace() or line=="\n"
def follow_rule6(line):
    return ""

# Style guideline #7: Indentation of multiline variables such as SRC_URI is desireable.
def check_rule7(line):
    return True
def follow_rule7(line):
    return line

rules = (
    (check_rule0, follow_rule0, "No spaces are allowed at the beginning of lines that define a variable or a do_ routine"),
    (check_rule1, follow_rule1, "No spaces are allowed behind the line continuation symbol '\\'"),
    (check_rule2, follow_rule2, "Tabs should not be used (use spaces instead)"),
    (check_rule3, follow_rule3, "Comments inside bb files are allowed using the '#' character at the beginning of a line"),
    (check_rule4, follow_rule4, "Use quotes on the right hand side of assignments: FOO = \"BAR\""),
    (check_rule5, follow_rule5, "The correct spacing for a variable is FOO = \"BAR\""),
    (check_rule6, follow_rule6, "Don't use spaces or tabs on empty lines"),
    (check_rule7, follow_rule7, "Indentation of multiline variables such as SRC_URI is desireable"),
)

def follow_rule(i, line):
    oldline = line
    if not rules[i][0](line):
        line = rules[i][1](line)
        if not rules[i][0](line):
            print "## Rule %d disgression: on this line: " % i, line
            print "## Warning: ", rules[i][2]
        else:
            print "## Reminder: ", rules[i][2], " in :", oldline
    return line


if __name__ == "__main__":

    # -- retrieves lines of the .bb file --
    lines = []
    for line in fileinput.input():
        if True:
            lines.append(line)
        else:
            # expandtabs on each line so that rule2 is always respected 
            # rstrip each line so that rule1 is always respected 
            line = line.expandtabs().rstrip()
            # ignore empty lines (or line filled with spaces or tabs only)
            # so that rule6 is always respected
            if line is not '':
                lines.append(line)

    # -- parse the file --
    var = ""
    in_routine = False
    commentBloc = []
    olines = []
    unknownVar = set()
    for line in lines: 
        line = line.rstrip()
        line = follow_rule(2, line)
        line = follow_rule(1, line)
        line = follow_rule(6, line)
        # ignore empty lines
        if line.isspace() or line is '':
            # flush comments into the olines
            for c in commentBloc: olines.append(c)
            commentBloc = []
            continue

        if line.startswith('}'): in_routine=False
        keep = line.endswith('\\') or in_routine

        # handles commented lines
        if line.lstrip().startswith('#'):
            # check and follow rule3 if not in a variables or routines
            if not in_routine:
                line = follow_rule(3, line)
            commentBloc.append(line)
            continue

        if OE_vars.has_key(var):
            for c in commentBloc: 
                OE_vars[var].append(c)
                commentBloc = []
            OE_vars[var].append(line)
        else:
            varexist = False
            for k in OE_vars:
                if line.startswith(k):
                    line = follow_rule(0, line)
                    varexist = True
                    if re.match(routineRegexp, line) is not None: 
                        in_routine=True
                    elif re.match(varRegexp, line) is not None:
                        line = follow_rule(4, line)
                        line = follow_rule(5, line)
                    for c in commentBloc: 
                        OE_vars[k].append(c)
                        commentBloc = []
                    OE_vars[k].append(line)
                    var = (keep==True or in_routine==True) and k or ""
                    break
            if not varexist:
                s = string.split(line)[0].rstrip().lstrip()
                if s not in unknownVar: 
                    unknownVar.add(s)
                if not in_routine:
                    print "## Warning: unknown variable/routine \"%s\"" % line
                    OE_vars['others'].append(line)
        if not keep and not in_routine: var = ""

    # -- prepare the sanitized .bb file --
    #for k in OE_vars: print k, OE_vars[k]
    addEmptyLine = False
    for k in OE_vars:
        if k=='SRC_URI': addEmptyLine = True
        if OE_vars[k] != []: 
            if addEmptyLine: olines.append("")
            for l in OE_vars[k]: 
                olines.append(l)
    for line in olines: print line
    #for i in unknownVar: print i, '\n'
