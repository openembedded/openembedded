DESCRIPTION = "Keyboard Device Daemon which provides support for snapntype and stowaway keyboards"
MAINTAINER = "Paul Eggleton <http://handhelds.org/moin/moin.cgi/PaulEggleton>"
SECTION = "utils"
LICENSE = "GPL"
PR = "r1"
DEPENDS = "virtual/kernel"
RDEPENDS = "kernel-module-keybdev kernel-module-uinput"
SRC_URI = "${HANDHELDS_CVS};module=apps/kbdd;date=${PV} \
           file://snapntype.patch;patch=1;pnum=0 \
           file://stowaway-fellowes-apm.patch;patch=1;pnum=0 \
           file://fellowes.init \ 
           file://stowaway.init \ 
           file://snapntype.init \
           file://kbdd.default"

inherit autotools

S = "${WORKDIR}/kbdd"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}/${sbindir}
	install -d ${D}/${docdir}/kbdd/
	install -m 0755 kbdd ${D}/${sbindir}/
	install -m 0644 README ${D}/${docdir}/kbdd/
}

do_install_append () {
        set -x
        install -d ${D}/${sysconfdir}/init.d
        cat ${WORKDIR}/fellowes.init | \
                sed -e 's,/usr/sbin/,${sbindir}/,g; s,/usr/bin/,${bindir}/,g; s,/usr/lib/,${libdir}/,g; s,/etc/,${sysconfdir}/,g; s,/usr/,${prefix}/,g;' > ${D}/${sysconfdir}/init.d/kbdd-fellowes
        cat ${WORKDIR}/stowaway.init | \
                sed -e 's,/usr/sbin/,${sbindir}/,g; s,/usr/bin/,${bindir}/,g; s,/usr/lib/,${libdir}/,g; s,/etc/,${sysconfdir}/,g; s,/usr/,${prefix}/,g;' > ${D}/${sysconfdir}/init.d/kbdd-stowaway
        cat ${WORKDIR}/snapntype.init | \
                sed -e 's,/usr/sbin/,${sbindir}/,g; s,/usr/bin/,${bindir}/,g; s,/usr/lib/,${libdir}/,g; s,/etc/,${sysconfdir}/,g; s,/usr/,${prefix}/,g;' > ${D}/${sysconfdir}/init.d/kbdd-snapntype
        chmod 755 ${D}/${sysconfdir}/init.d/kbdd-fellowes
        chmod 755 ${D}/${sysconfdir}/init.d/kbdd-stowaway
        chmod 755 ${D}/${sysconfdir}/init.d/kbdd-snapntype
        mkdir -p ${D}/${sysconfdir}/defaults
        cat ${WORKDIR}/kbdd.default > ${D}/${sysconfdir}/defaults/kbdd
        chmod 755 ${D}/${sysconfdir}/defaults/kbdd
        mkdir -p ${D}/${sysconfdir}/modutils
        touch ${D}/${sysconfdir}/modutils/kbdd-modules
        echo "keybdev" > ${D}/${sysconfdir}/modutils/kbdd-modules
        echo "uinput" >> ${D}/${sysconfdir}/modutils/kbdd-modules
        chmod 755 ${D}/${sysconfdir}/modutils/kbdd-modules
}

pkg_postinst () {
        if test -n "${D}"; then
                D="-r"
        fi
#        update-rc.d $D kbdd-fellowes defaults
#        update-rc.d $D kbdd-stowaway defaults
        update-rc.d $D kbdd-snapntype defaults
        update-modules
}

pkg_prerm () {
        if test -n "${D}"; then
                D="-r"
        fi
        update-rc.d $D kbdd-fellowes remove
        update-rc.d $D kbdd-stowaway remove
        update-rc.d $D kbdd-snapntype remove
        rm ${D}/${sysconfdir}/modutils/kbdd-modules
        update-modules
}
