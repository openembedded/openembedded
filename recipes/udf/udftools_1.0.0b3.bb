DESCRIPTION = "Linux UDF Filesystem userspace utilities"
LICENSE = "GPLv2"

REALPV = "1.0.0b3"
PV = "0.9.8+${REALPV}"

SRC_URI = "http://downloads.sourceforge.net/project/linux-udf/udftools/${REALPV}/udftools-${REALPV}.tar.gz \
file://patch-01-pktsetup-chardev.diff \
file://patch-02-pktsetup-exitstatus.diff \
file://patch-03-mkudffs-bigendian.diff \
file://patch-04-wrudf-gcc4.diff \
file://patch-05-pktsetup-manpage.diff \
file://patch-06-wrudf-lvalue.diff \
file://patch-07-cdrwtool-manpage.diff \
file://patch-08-mkudffs-manpage.diff \
file://patch-09-include-stringh.diff \
file://patch-10-mkudffs-open-error.diff \
file://patch-11-udftools-limits-h.diff \
file://patch-12-pktsetup-limits-h.diff \
"

SRC_URI[md5sum] = "2f491ddd63f31040797236fe18db9e60"
SRC_URI[sha256sum] = "c5079e878d4d8e03de0fd75bfecf485a299689b8289a5288f18b2e793e0904a0"

S = "${WORKDIR}/${PN}-${REALPV}"

inherit autotools

