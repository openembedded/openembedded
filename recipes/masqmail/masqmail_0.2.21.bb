DESCRIPTION = "MasqMail is a mail server designed for hosts that do not have \
a permanent internet connection eg. a home network or a single host at home. \
It has special support for connections to different ISPs. It replaces sendmail \
or other MTAs such as qmail or exim."
HOMEPAGE = "http://innominate.org/kurth/masqmail/"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "glib-2.0"

SRC_URI = "${DEBIAN_MIRROR}/main/m/${PN}/${PN}_${PV}.orig.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF += "--disable-glibtest"
EXTRA_OECONF += "--disable-resolver"

# These are the standard Debian values for ownership of the programs,
# this stuff fakes out the install script chown operations then replicates
# them by setting the ipkg owner/group to the desired values - everything
# ends up owned by the nominated user.
MAIL_USER ?= "mail"
MAIL_GROUP ?= "mail"

EXTRA_OECONF += "--with-user=$(id -u)"
EXTRA_OECONF += "--with-group=$(id -g)"

IPKGBUILDCMD = "ipkg-build -o ${MAIL_USER} -g ${MAIL_GROUP}"

SRC_URI[md5sum] = "7e989a8b0562054aea22c654507f2cb5"
SRC_URI[sha256sum] = "2257099c760c12daf094744c6b2269d476e3bc6b523366168ad81bdd2ebd2445"
