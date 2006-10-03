require apt.inc

require apt-package.inc

FILES_${PN} += "${bindir}/apt-key"
apt-manpages += "doc/apt-key.8"

do_install () {
        set -x
        ${@get_commands_apt_doc(d, bb, bb.data.getVar('apt-manpages', d, 1))}
        ${@get_commands_apt_doc(d, bb, bb.data.getVar('apt-utils-manpages', d, 1))}
        install -d ${D}${bindir}
        install -m 0755 bin/apt-cdrom ${D}${bindir}/
        install -m 0755 bin/apt-get ${D}${bindir}/
        install -m 0755 bin/apt-config ${D}${bindir}/
        install -m 0755 bin/apt-cache ${D}${bindir}/

        install -m 0755 bin/apt-sortpkgs ${D}${bindir}/
        install -m 0755 bin/apt-extracttemplates ${D}${bindir}/
        
        eval `cat environment.mak | grep ^GLIBC_VER | sed -e's, = ,=,'`
        oe_libinstall -a -C bin libapt-pkg ${D}${libdir}/
        ln -sf libapt-pkg$GLIBC_VER-6.so ${D}${libdir}/libapt-pkg.so
        oe_libinstall -a -C bin libapt-inst ${D}${libdir}/
        ln -sf libapt-inst$GLIBC_VER-6.so ${D}${libdir}/libapt-inst.so
                        
        install -d ${D}${libdir}/apt/methods 
        install -m 0755 bin/methods/* ${D}${libdir}/apt/methods/

        install -d ${D}${libdir}/dpkg/methods/apt
        install -m 0644 dselect/desc.apt ${D}${libdir}/dpkg/methods/apt/
        install -m 0644 dselect/names ${D}${libdir}/dpkg/methods/apt/
        install -m 0755 dselect/install ${D}${libdir}/dpkg/methods/apt/
        install -m 0755 dselect/setup ${D}${libdir}/dpkg/methods/apt/
        install -m 0755 dselect/update ${D}${libdir}/dpkg/methods/apt/

        install -d ${D}${sysconfdir}/apt
        install -d ${D}${localstatedir}/lib/apt/lists/partial
        install -d ${D}${localstatedir}/cache/apt/archives/partial
        install -d ${D}${docdir}/apt/examples
        install -m 0644 doc/examples/* ${D}${docdir}/apt/examples/
}

