DESCRIPTION = "Paroli"
SECTION = "x11"
LICENSE = "GPL"
PV = "0.2.1+gitr${SRCREV}"
PR = "r9"

SRC_URI = "git://git.paroli-project.org/paroli.git;protocol=http"
S = "${WORKDIR}/git"

inherit distutils

PACKAGES += "${PN}-autostart ${PN}-theme ${PN}-sounds"

RDEPENDS = "\
  python-datetime \
  python-subprocess \
  python-textutils \
  python-dbus \
  python-pygobject \
"

#E_CONFIG_DIR="/home/root/.e/e"
E_CONFIG_DIR="/usr/share/enlightenment/data"

do_install_append() {
       	# install paroli theme
       	install -d ${D}${E_CONFIG_DIR}/config/illume/
       	install ${S}/data/module.illume.cfg ${D}${E_CONFIG_DIR}/config/illume/
       	install ${S}/data/e.cfg ${D}${E_CONFIG_DIR}/config/illume/
       	install -d ${D}${E_CONFIG_DIR}/themes
	install ${S}/data/illume.edj ${D}${E_CONFIG_DIR}/themes
	install -d ${D}${datadir}/elementary/themes
	install ${S}/data/default.edj ${D}${datadir}/elementary/themes
    	install -d ${D}/etc/enlightenment/
	echo 'E_PROFILE="-profile illume"' > ${D}${sysconfdir}/enlightenment/default_profile

       	# install autostart
    	install -d ${D}${E_CONFIG_DIR}/applications/all
	cp ${D}/usr/share/applications/paroli.desktop ${D}${E_CONFIG_DIR}/applications/all
    	install -d ${D}${E_CONFIG_DIR}/applications/startup
       	echo "${E_CONFIG_DIR}/applications/all/paroli.desktop" >> ${D}${E_CONFIG_DIR}/applications/startup/.order

	install -d ${D}${sysconfdir}/freesmartphone/oevents
	install ${S}/data/rules.yaml ${D}${sysconfdir}/freesmartphone/oevents/rules.yaml
	install ${S}/data/frameworkd.conf ${D}${sysconfdir}/frameworkd.conf

	install -d ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone
	install ${S}/data/default.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml

	install -d ${D}${datadir}/sounds
	install ${S}/data/sounds/* ${D}${datadir}/sounds

}

pkg_postinst_${PN}-autostart() {
#!/bin/sh
# post installation script
echo "*******************************************"
echo "Deactivating zhone autostart"
echo "*******************************************"
chmod -x ${sysconfdir}/X11/Xsession.d/80zhone || true
exit 0
}

pkg_postinst_${PN}() {
#!/bin/sh
# post installation script
#mv ${sysconfdir}/frameworkd.conf ${sysconfdir}/old_frameworkd.conf
#cp ${sysconfdir}/frameworkd_paroli.conf ${sysconfdir}/frameworkd.conf
#mv ${sysconfdir}/freesmartphone/oevents/rules.yaml ${sysconfdir}/freesmartphone/oevents/old_rules.yaml
#cp ${sysconfdir}/freesmartphone/oevents/paroli_rules.yaml ${sysconfdir}/freesmartphone/oevents/rules.yaml
exit 0
}

pkg_postinst_${PN}-sounds() {
#!/bin/sh
# post installation script
#mv ${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml ${sysconfdir}/freesmartphone/opreferences/conf/phone/old_default.yaml
#cp ${sysconfdir}/freesmartphone/opreferences/conf/phone/paroli_default.yaml ${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml
exit 0
}

FILES_${PN} += " \
	    ${sysconfdir}/dbus-1 \
	    ${sysconfdir}/paroli \
	    ${sysconfdir}/freesmartphone/oevents \
	    ${sysconfdir}/frameworkd.conf \ 
	    ${datadir} \
	    "

FILES_${PN}-theme = " \
		  ${E_CONFIG_DIR}/themes \
		  ${E_CONFIG_DIR}/config \
		  ${sysconfdir}/enlightenment \
		  "

FILES_${PN}-autostart = "${E_CONFIG_DIR}/applications"

FILES_${PN}-sounds = " \
	${datadir}/sounds/ \
	${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml \
	"

CONFFILES_${PN} += " \
	${sysconfdir}/frameworkd.conf \
	${sysconfdir}/freesmartphone/oevents/rules.yaml \
	"
CONFFILES_${PN}-sounds += " \
	${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml \
	"
