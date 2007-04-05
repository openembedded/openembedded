# ex:ts=4:sw=4:sts=4:et
# -*- tab-width: 4; c-basic-offset: 4; indent-tabs-mode: nil -*-
#
#
# Copyright (C)       2005 Holger Hans Peter Freyther
# All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are met:
#
#   Redistributions of source code must retain the above copyright notice,
#   this list of conditions and the following disclaimer.
#
#   Redistributions in binary form must reproduce the above copyright
#   notice, this list of conditions and the following disclaimer in the
#   documentation and/or other materials provided with the distribution.
#
#   Neither the name Holger Hans Peter Freyther nor the names of its
#   contributors may be used to endorse or promote products derived
#   from this software without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
# "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
# LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
# FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
# COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
# INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
# (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
# SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
# HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
# STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING
# IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
# POSSIBILITY OF SUCH DAMAGE.

from bittest import TestItem
from bb      import data
import types

#
# The tests are copied from the oelint.bbclass to this location
#


# quite simple without regexps
bad_signs = {
    'SRC_URI' : '?', # SRC_URI should not contain URLs like http://foo.foo?file=foo.tar.gz
    'RDEPENDS': 'kernel-module-' # According to reenoo this is always wrong
}

# Test for the HOMEPAGE
def homepage1():
    return lambda fn,value : [None,TestItem(fn,False,"HOMEPAGE is not set %s" % value)] [value == 'unknown']

def homepage2():
    return lambda fn,value : [None,TestItem(fn,False,"HOMEPAGE doesn't start with http://")][not value.startswith("http://")]

# Test for the MAINTAINER
def maintainer1():
    return lambda fn,value : [None,TestItem(fn,False, "explicit MAINTAINER is missing, using default"), None][value == "OpenEmbedded Team <oe@handhelds.org>"]

def maintainer2():
    return lambda fn, value : [None,TestItem(fn,False,"You forgot to put an e-mail address into MAINTAINER"),None] [value.find("@") == -1]


# Check the licenses of the Files
valid_licenses = {
    "GPL-2"     : "GPLv2",
    "GPL LGPL FDL" : True,
    "GPL PSF"   : True,
    "GPL/QPL"   : "GPL QPL",
    "GPL QPL"   : True,
    "GPL"       : True,
    "GPLv2"     : True,
    "GPLV2"     : "GPLv2",
    "IBM"       : True,
    "LGPL GPL"  : True,
    "LGPL"      : True,
    "MIT"       : True,
    "OSL"       : True,
    "Perl"      : True,
    "Public Domain" : True,
    "QPL"       : True,
    "Vendor"    : True,
    "BSD"       : True,
    "tickypip-levels" : True,
    "unknown"   : False,
}

def license2():
    return lambda fn, value : [None,TestItem(fn,False,"LICENSE '%s' is not known" % value),None][not valid_licenses.has_key(value)]

def license3():
    return lambda fn, value : [None,TestItem(fn,False,"LICENSE '%s' is not recommed, better use '%s'" % (value,valid_licenses[value])),None][valid_licenses[value] != True]
def license1():
    return lambda fn, value : [None,TestItem(fn,False,"LICENSE is not set %s" % value)][value == "unknown"]

# Check the priorities here...
valid_priorities = {
    "standard"      : True,
    "required"      : True,
    "optional"      : True,
    "extra"         : True,
}


def priority1():
    return lambda fn, value : [None,TestItem(fn,False,"PRIORITY '%s' is not known" % value)][not valid_priorities.has_key(value)]

def priority2():
    return lambda fn, value : [None,TestItem(fn,False,"PRIORITY '%s' is not recommed" % value)][valid_priorities[value]==False]


# Test the SECTION now
valid_sections = {
    # Current Section         Correct section
    "apps"			: True,
    "audio"			: True,
    "base"			: True,
    "console/games"		: True,
    "console/net"		: "console/network",
    "console/network"	: True,
    "console/utils"		: True,
    "devel"			: True,
    "developing"		: "devel",
    "devel/python"		: True,
    "fonts"			: True,
    "games"			: True,
    "games/libs"		: True,
    "gnome/base"		: True,
    "gnome/libs"		: True,
    "gpe"			: True,
    "gpe/libs"		: True,
    "gui"			: False,
    "libc"			: "libs",
    "libs"			: True,
    "libs/net"		: True,
    "multimedia"		: True,
    "net"			: "network",
    "NET"			: "network",
    "network"		: True,
    "opie/applets"		: True,
    "opie/applications"	: True,
    "opie/base"		: True,
    "opie/codecs"		: True,
    "opie/decorations"	: True,
    "opie/fontfactories"	: True,
    "opie/fonts"		: True,
    "opie/games"		: True,
    "opie/help"		: True,
    "opie/inputmethods"	: True,
    "opie/libs"		: True,
    "opie/multimedia"	: True,
    "opie/pim"		: True,
    "opie/setting"		: "opie/settings",
    "opie/settings"		: True,
    "opie/Shell"		: False,
    "opie/styles"		: True,
    "opie/today"		: True,
    "scientific"		: True,
    "utils"			: True,
    "x11"			: True,
    "x11/libs"		: True,
    "x11/wm"		: True,
}

def section1():
    return lambda fn,value : [None,TestItem(fn,False,"SECTION '%s' is not known" % value)][not valid_sections.has_key(value)]
def section2():
    return lambda fn,value : [None,TestItem(fn,False,"SECTION '%s' is not reccomed use '%s' instead" % (value,valid_sections[value]))][valid_sections[value]!=True]



# these are checks we execute on each variable
variable_checks = {
    'DESCRIPTION' : None,  # we only want the presence check
    'HOMEPAGE'    : [homepage1(),homepage2()],
    'LICENSE'     : [license1(),license2(),license3()],
    'MAINTAINER'  : [maintainer1(),maintainer2()],
    'SECTION'     : [section1(),section2()],
    'PRIORITY'    : [priority1(), priority2()],
}

class TestCase:
    """
    Check if keys contain weird expressions that are considered
    error prone.
    """

    def __init__(self):
        pass

    def test(self, file_name, file_data):
        """
        Go through bad_signs and do reports
        """
        results = []

        # apply the heuristics
        for sign in bad_signs.keys():
            try:
                value = data.getVar(sign, file_data, True)
            except:
                try:
                    value = data.getVar(sign, file_data, False)
                except:
                    pass

            if not value == None:
                if bad_signs[sign] in value:
                    results.append( TestItem(file_name,False,"BAD sign found for %s." % sign))

        # apply the variable content check
        for variable in variable_checks.keys():
            value = data.getVar(variable, file_data, True)

            # is this require variable present
            if value == None:
                result.append( TestItem(file_name,False, "Required variable '%(variable)s' not found." % vars()) )
            else:
                checks = variable_checks[variable]
                # now check if we need to check a list of checks
                if type(checks) == types.ListType:
                    for check in checks:
                        res = check(file_name, value)
                        # if one test failed we will stop here
                        if res:
                            results.append( res )
                            print "Stopping the check for variable %s" % variable
                            break
                elif checks:
                    res = checks(file_name, value)
                    if res:
                        results.append( res )

        return results

    def test_name(self):
        return "Content Checker Tool"
