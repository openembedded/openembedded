# This package builds tools to manage NIS
# The source package is utils/net/NIS/yp-tools
#
PR = "r0"
DESCRIPTION="\
Network Information Service tools.  \
This package contains ypcat, ypmatch, ypset, \
ypwhich, yppasswd, domainname, nisdomainname \
and ypdomainname."

require nis.inc

SRC_URI[md5sum] = "19de06a04129ec26773f9198e086fcd4"
SRC_URI[sha256sum] = "65c27f5c9ef3af56b17108ecb2e89276e0fe8722152d4353bb86672c1060a718"
