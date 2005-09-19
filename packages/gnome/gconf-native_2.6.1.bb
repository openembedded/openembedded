NOTE = "This is just a dummy package to get packages stop complaining about gconftool-2 \
        which they are not using anyway... :D"

inherit native

do_stage() {
	echo "#!/bin/sh" >${STAGING_BINDIR}/gconftool-2
	chmod a+rx ${STAGING_BINDIR}/gconftool-2
}

