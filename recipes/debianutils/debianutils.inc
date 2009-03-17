SECTION = "base"
LICENSE = "GPL BSD BSD SMAIL"
DESCRIPTION = "Miscellaneous utilities specific to Debian"

SRC_URI = "${DEBIAN_MIRROR}/main/d/${PN}/${PN}_${PV}.tar.gz"

inherit autotools 

do_install_append() {
    for app in ${D}/${sbindir}/* ${D}/${bindir}/*; do
        mv $app $app.${PN}
    done
}

pkg_postinst_${PN} () {
#!/bin/sh
for app in add-shell  installkernel  mkboot  remove-shell ; do
    update-alternatives --install ${sbindir}/$app $app $app.${PN} 100
done

for app in run-parts  savelog  sensible-browser  sensible-editor  sensible-pager  tempfile  which ; do
    update-alternatives --install ${bindir}/$app $app $app.${PN} 100
done
}

pkg_prerm_${PN} () {
 #!/bin/sh

for app in add-shell  installkernel  mkboot  remove-shell run-parts  savelog  sensible-browser  sensible-editor  sensible-pager  tempfile  which ; do
   update-alternatives --remove $app $app.${PN}
done
}



