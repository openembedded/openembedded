SECTION = "base"
DESCRIPTION = "pstree cli tool to nicely show processes tree"
LICENSE = "GPL"
DEPENDS = "libnl"
PR = "r0"

S = "${WORKDIR}"

do_compile() {
  ${CC} -O ${CFLAGS} ${LDFLAGS} -o pstree pstree.c
}

do_install() {
  install -d ${D}/bin/
  install -m 0755 pstree ${D}/bin/
}

SRC_URI = "\
  ftp://ftp.thp.uni-duisburg.de/pub/source/${PN}-${PV}.tar.gz \
"

SRC_URI[md5sum] = "b0a85caacd85f78bd83700afa86ec2e9"
SRC_URI[sha256sum] = "0f06116208cf15932cf99785d001c053e523e0aed474b936858f1b7f61a6c990"
