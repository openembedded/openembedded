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
