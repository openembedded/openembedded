DESCRIPTION = "Tool to edit the Redboot FIS partition layout from userspace"
PR = "r4"

SRC_URI = "svn://svn.nslu2-linux.org/svnroot/fis;module=trunk;proto=http"
S="${WORKDIR}/trunk"

export CFLAGS += "--std=c99"

do_install() {
	${STRIP} ${S}/fis

	install -d ${D}/${sbindir}
	install -m 755 ${S}/fis ${D}/${sbindir}
}
