DESCRIPTION = "Paroli"
SECTION = "x11"
LICENSE = "GPL"
PV = "0.2.1+gitr${SRCREV}"
PR = "r19"

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
  dbus-x11 \
  task-fso-compliance \
  elementary \
  elementary-themes \
"

E_CONFIG_DIR="/usr/share/enlightenment/data"

RULES_YAML = rules.yaml
RULES_YAML_om-gta01 = gta01_rules.yaml

do_install_append() {
       	# install paroli theme
       	install -d ${D}${E_CONFIG_DIR}/themes
       	install ${S}/data/e-config/paroli.edj ${D}${E_CONFIG_DIR}/themes/
       	install -d ${D}${E_CONFIG_DIR}/config/paroli
       	install ${S}/data/e-config/paroli/* ${D}${E_CONFIG_DIR}/config/paroli/
       	install -d ${D}${E_CONFIG_DIR}/themes
	#install ${S}/data/illume.edj ${D}${E_CONFIG_DIR}/themes
	install -d ${D}${datadir}/elementary/themes
	install ${S}/data/default.edj ${D}${datadir}/elementary/themes
#    	install -d ${D}/etc/enlightenment/
#	echo 'E_PROFILE="-profile illume"' > ${D}${sysconfdir}/enlightenment/default_profile

    	install -d ${D}${datadir}/pixmaps	
	install ${S}/data/paroli.png ${D}${datadir}/pixmaps

       	# install autostart
    	install -d ${D}${E_CONFIG_DIR}/applications/all
	cp ${D}/usr/share/applications/paroli.desktop ${D}${E_CONFIG_DIR}/applications/all
    	install -d ${D}${E_CONFIG_DIR}/applications/startup
       	echo "${E_CONFIG_DIR}/applications/all/paroli.desktop" >> ${D}${E_CONFIG_DIR}/applications/startup/.order

	install -d ${D}${sysconfdir}/freesmartphone/oevents
	install ${S}/data/${RULES_YAML} ${D}${sysconfdir}/freesmartphone/oevents/paroli_rules.yaml
	install ${S}/data/frameworkd.conf ${D}${sysconfdir}/paroli_frameworkd.conf

	install -d ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone
	install ${S}/data/default.yaml ${D}${sysconfdir}/freesmartphone/opreferences/conf/phone/paroli_default.yaml

	install -d ${D}${datadir}/dbus-1/system-services/
	install ${S}/data/dbus/org.tichy.launcher.service ${D}${datadir}/dbus-1/system-services/

	install -d ${D}${datadir}/sounds
	install ${S}/data/sounds/* ${D}${datadir}/sounds

}

pkg_postinst_${PN}-autostart() {
#!/bin/sh
# post installation script
if [ -x $IMAGE_ROOTFS${sysconfdir}/X11/Xsession.d/80zhone ]; then
   echo "*******************************************"
   echo "Deactivating zhone autostart"
   echo "*******************************************"
   chmod -x $IMAGE_ROOTFS${sysconfdir}/X11/Xsession.d/80zhone || true
fi
exit 0
}

pkg_postinst_${PN}() {
#!/bin/sh
# post installation script
echo "*******************************************"
echo "Paroli post processing"
echo "*******************************************"
if [ ! -e $IMAGE_ROOTFS${sysconfdir}/old_frameworkd.conf ] ; then
    echo "Backing up ${sysconfdir}/frameworkd.conf"
    mv $IMAGE_ROOTFS${sysconfdir}/frameworkd.conf $IMAGE_ROOTFS${sysconfdir}/old_frameworkd.conf
fi
mv $IMAGE_ROOTFS${sysconfdir}/paroli_frameworkd.conf $IMAGE_ROOTFS${sysconfdir}/frameworkd.conf
if [ ! -e $IMAGE_ROOTFS${sysconfdir}/freesmartphone/oevents/old_rules.yaml ] ; then
    echo "Backing up $IMAGE_ROOTFS${sysconfdir}/freesmartphone/oevents/rules.yaml"
    mv $IMAGE_ROOTFS${sysconfdir}/freesmartphone/oevents/rules.yaml $IMAGE_ROOTFS${sysconfdir}/freesmartphone/oevents/old_rules.yaml
fi
cp $IMAGE_ROOTFS${sysconfdir}/freesmartphone/oevents/paroli_rules.yaml $IMAGE_ROOTFS${sysconfdir}/freesmartphone/oevents/rules.yaml
exit 0
}

pkg_postinst_${PN}-sounds() {
#!/bin/sh
# post installation script
if [ ! -e /$IMAGE_ROOTFS${sysconfdir}/freesmartphone/opreferences/conf/phone/old_default.yaml ] ; then
    echo "Backing up ${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml"
    mv $IMAGE_ROOTFS${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml $IMAGE_ROOTFS${sysconfdir}/freesmartphone/opreferences/conf/phone/old_default.yaml
fi
cp $IMAGE_ROOTFS${sysconfdir}/freesmartphone/opreferences/conf/phone/paroli_default.yaml $IMAGE_ROOTFS${sysconfdir}/freesmartphone/opreferences/conf/phone/default.yaml
exit 0
}

pkg_postinst_${PN}-theme() {
#!/bin/sh
# post installation script
echo 'E_PROFILE="-profile paroli"' > $IMAGE_ROOTFS${sysconfdir}/enlightenment/default_profile
exit 0
}

FILES_${PN} += " \
	${sysconfdir}/dbus-1 \
	${sysconfdir}/paroli \
	${sysconfdir}/freesmartphone/oevents \
	${sysconfdir}/paroli_frameworkd.conf \ 
#	${sysconfdir}/frameworkd.conf \ 
	${datadir}/lib \
	${datadir}/bin \
	${datadir}/applications \
	${datadir}/elementary \
	${datadir}/paroli \
	${datadir}/pixmaps \
	${datadir}/dbus-1/system-services/ \
	"

FILES_${PN}-theme = " \
	${E_CONFIG_DIR}/themes \
	${E_CONFIG_DIR}/config \
	"

FILES_${PN}-autostart = "${E_CONFIG_DIR}/applications"

FILES_${PN}-sounds = " \
	${datadir}/sounds/ \
	${sysconfdir}/freesmartphone/opreferences/conf/phone/paroli_default.yaml \
	"

#CONFILES_${PN}-theme = " \
#	${sysconfdir}/enlightenment/default_profile \
#	"

CONFFILES_${PN} += " \
	${sysconfdir}/paroli/paroli.cfg \
	${sysconfdir}/paroli_frameworkd.conf \
#	${sysconfdir}/frameworkd.conf \
	${sysconfdir}/freesmartphone/oevents/paroli_rules.yaml \
	"
CONFFILES_${PN}-sounds += " \
	${sysconfdir}/freesmartphone/opreferences/conf/phone/paroli_default.yaml \
	"
