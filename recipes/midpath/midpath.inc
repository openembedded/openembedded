# This is the include recipe for the midpath recipes for your platform.
#
# To support your particular platform, write a proper configuration, add
# a new recipe and decided which components it should install by modifying
# RDEPENDS.
require midpath-common.inc

RDEPENDS_${PN} = "midpath-core midpath-core-bluetooth midpath-core-ogg ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'midpath-core-mp3', d)}"

PROVIDES = "midpath"
RPROVIDES_${PN} = "midpath"

CONFIGURATION = "${@bb.fatal('Variable CONFIGURATION is not set in your midpath.inc-based recipe.')}"

do_compile() {
  :
}

do_install() {
	# Installation of configuration.cfg:
  # Creates a symbolic link at ${datadir}/midpath which points to ${sysconfdir}/midpath
  install -d ${D}${datadir}/midpath/configuration/com/sun/midp/configuration
  ln -sf ${sysconfdir}/midpath/configuration.cfg ${D}${datadir}/midpath/configuration/com/sun/midp/configuration/configuration.cfg

  # Put the file itself into ${sysconfdir}/midpath
  install -d ${D}${sysconfdir}/midpath
  install -m 0644 ${WORKDIR}/${CONFIGURATION} ${D}${sysconfdir}/midpath/configuration.cfg

  # Same procedure for MIDP2.0 required system properties
  ln -sf ${sysconfdir}/midpath/system_properties ${D}${datadir}/midpath/configuration/com/sun/midp/configuration/system_properties
  install -m 0644 configuration/com/sun/midp/configuration/system_properties ${D}${sysconfdir}/midpath

  # Put l10n data into $datadir
  install -d ${D}${datadir}/midpath/configuration/com/sun/midp/configuration/l10n
  install -m 0644 configuration/com/sun/midp/configuration/l10n/en-US.xml ${D}${datadir}/midpath/configuration/com/sun/midp/configuration/l10n
}

PACKAGES = "${PN}"

FILES_${PN} = "\
	${datadir}/midpath/configuration \
  ${sysconfdir}/midpath \
	"

CONFFILES_${PN} = "\
  ${sysconfdir}/midpath/system_properties \
  ${sysconfdir}/midpath/configuration.cfg \
  "

