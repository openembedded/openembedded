DESCRIPTION = "nylon preliminary web configuration interface"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE = "closed"
DEPENDS = "perl virtual/kernel hostap-daemon busybox"
RDEPENDS = "perl perl-module-exporter perl-module-posix perl-module-autoloader perl-module-strict perl-module-xsloader perl-module-data-dumper perl-module-carp perl-module-bytes perl-module-overload perl-module-warnings-register perl-module-warnings  kernel-module-aes madwifi-modules hostap-daemon simple-firewall wlan-ng-utils busybox-httpd"
CVSDATE = "20051026"
PV = "cvs${CVSDATE}"

SRC_URI = "http://br1.einfach.org/nylon/stable/sources/nylon-config_gruen.4g__20051026.tar.gz"
S = "${WORKDIR}/${PN}"

do_install() {
	(cd ${S}; tar -c --exclude .svn -f - . ) | tar -C ${D} -xpf -
	# chmod 600 ${D}/etc/certs/stunnel.key
	chmod a+x ${D}/srv/www/cgi-bin/*
}

pkg_postinst() {
#!/bin/sh
if test "x$D" != "x"; then
	exit 1
fi

# Create resolv.conf-link to ppp-file
rm /etc/resolv.conf
ln -s /etc/ppp/resolv.conf /etc/resolv.conf

# enable factorydefaults
update-rc.d factorydefaults start 90 2 .

# "fix" /etc/network/interfaces
perl -I /srv/www/cgi-bin -MConfig::IFace -e '$w=new Config::IFace(); $v = $w->read(); $v->{auto} = {0=>"lo",1=>eth0,2=>"wlan0",3=>"wlan1",4=>"ath0",5=>"ath1"}; $w->write($v)'

update-rc.d busybox-httpd start 40 2 3 4 5 .
/etc/init.d/busybox-httpd restart
}

FILES_${PN} += "/srv"


SRC_URI[md5sum] = "f373680b3b792925eb5293eafe487168"
SRC_URI[sha256sum] = "c848b2a53396e51fccb589c56ddba928671f08d30bece7883dc69f4fa5f8e113"
