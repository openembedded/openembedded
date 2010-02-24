DESCRIPTION = "Fast and portable XML parser and Jabber protocol library"
AUTHOR = "Gurer Ozen <meduketto at gmail.com>"
HOMEPAGE = "http://iksemel.googlecode.com"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "gnutls"

SRC_URI = "http://iksemel.googlecode.com/files/${P}.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "532e77181694f87ad5eb59435d11c1ca"
SRC_URI[archive.sha256sum] = "458c1b8fb3349076a6cecf26c29db1d561315d84e16bfcfba419f327f502e244"

inherit autotools_stage pkgconfig
