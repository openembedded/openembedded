# This package builds tools to manage NIS passwords
# The source package is utils/net/NIS/pwdutils
# The package requires -lpam
#
PR = "r1"
DESCRIPTION="\
NIS PAM password management tools.  \
This is a collection of utilities to manage the passwd \
information stored in local files, NIS, NIS+ or LDAP \
and can replace the shadow suite completely."
HOMEPAGE="http://lists.suse.com/archive/pwdutils/"

include nis.inc

# an selinux API is used even if no selinux is detected by
# configure.
SRC_URI += " file://no-selinux.patch;patch=1"
SRC_URI += " file://libdl.patch;patch=1"

DEPENDS += " libpam openldap openssl"

# -Werror is set within the pwdutils configure.in!
# You might prefer to use -Wno-error rather than the
# following long list.
#
# #if undefined happens in bits/string2.h and probably
# elsewhere (since it is a standard safe C programming
# practice - safer than #ifdef!)
TARGET_CFLAGS += " -Wno-undef"
# bits/socket.h has a macro which casts 'up' (increasing
# the alignment requirement) but it is in a macro which
# does the alignment correctly, so the following warning
# needs to be non-error'ed.  I just turn it off...
TARGET_CFLAGS += " -Wno-cast-align"
# openssl contains large numbers of declarations wherein
# f() is used instead of f(void), so:
TARGET_CFLAGS += " -Wno-strict-prototypes"
# openssl uses error as a local variable, so:
TARGET_CFLAGS += " -Wno-shadow"
