SECTION = "devel"
DESCRIPTION = "makeself.sh is a small shell script that generates a \
self-extractable tar.gz archive from a directory. The resulting file \
appears as a shell script (many of those have a .run suffix), and \
can be launched as is. The archive will then uncompress itself to a \
temporary directory and an optional arbitrary command will be executed \
(for example an installation script)."
LICENSE = "GPL"
SRC_URI = "cvs://anonymous:anonymous@cvs.icculus.org/cvs/cvsroot;module=loki_setup/makeself"
S = "${WORKDIR}/makeself"

inherit native

do_stage() {
	install -m 0755 makeself.sh makeself-header.sh ${STAGING_BINDIR}/
}
