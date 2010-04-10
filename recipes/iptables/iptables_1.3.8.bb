require iptables.inc
PR = "${INC_PR}.0"
EXTRA_OEMAKE = "'COPT_FLAGS=${CFLAGS}' \
                'KERNEL_DIR=${STAGING_INCDIR}' \
                'LDFLAGS=${LDFLAGS}' \
                ${@base_contains('DISTRO_FEATURES', 'ipv6', 'DO_IPV6=1', 'DO_IPV6=0', d)} \
                \
                'PREFIX=${prefix}' \
                'LIBDIR=${libdir}' \
                'BINDIR=${sbindir}' \
                'MANDIR=${mandir}' \
                'INCDIR=${includedir}'"
CFLAGS[unexport] = "1"

SRC_URI += "\
  file://getsockopt-failed.patch;patch=1 \
  file://iptables-use-s6_addr32.patch;patch=1 \
  file://cross-iptables.diff;patch=1 \
"

do_install () {
    oe_runmake 'DESTDIR=${D}' install
}

SRC_URI[iptables-1.3.8.md5sum] = "0a9209f928002e5eee9cdff8fef4d4b3"
SRC_URI[iptables-1.3.8.sha256sum] = "c5c8a091ed9a1fa2dab86b4d87719064b50c202e8503046f50f299a361e6211c"
