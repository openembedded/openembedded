DESCRIPTION = "TENEX C Shell, an enhanced version of Berkeley csh"
LICENSE = "BSD"
SECTION = "base/shell"
HOMEPAGE = "http://www.tcsh.org/"

SRC_URI = "ftp://ftp.astron.com/pub/tcsh/tcsh-${PV}.tar.gz \
           file://native-gethost.patch;patch=1"

inherit autotools
