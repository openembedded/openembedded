DEPENDS = " \
base-files \
bash \
bridge-utils \
busybox \
chillispot \
dash \
db3 \
ddclient \
dhcp-forwarder \
dhcp \
dnsmasq \
expat \
gdb \
glib-2.0 \
glibc \
gmp \
gnupg \
hostap-modules \
hostap-utils \
hostap-daemon \
linux-hotplug \
htb-init \
ifplugd \
initscripts \
iperf \
ipkg \
iproute2 \
iptables \
virtual/kernel \
kismet \
less \
libcgicc \
libmail-sendmail-perl \
libnetserver-generic-perl \
libpcap \
lsof \
lzo \
madwifi-modules \
maradns \
mc \
mobilemesh \
modutils \
mtd-utils \
mtr \
nano \
ncurses \
netbase \
netperf \
net-snmp \
ntp \
nylon-scripts \
nylon-statistics \
olsrd \
openssh \
openssl \
openvpn \
openswan \
pciutils \
pcre \
perl \
pmacct \
ppp \
ppp-dsl \
rp-pppoe \
rrdtool \
prism2-firmware-update \
prism54-module \
prism54-firmware \
shorewall \
stunnel \
sysvinit \
tcpdump \
tinc \
timezones \
usbutils \
vtun \
wireless-tools \
wlan-ng-modules \
yamonenv \
zlib \
"

# TODO:
# ksymoops / binutils
# strace: SYS_read?
# gdb-cross: install paths, sdk?
# screen: sgttyb?
# nocat?
# pptp
# meshroaming

do_index() {
	ipkg-make-index -r ${DEPLOY_DIR_IPK}/Packages -p ${DEPLOY_DIR_IPK}/Packages -l ${DEPLOY_DIR_IPK}/Packages.filelist -m ${DEPLOY_DIR_IPK}    
}

addtask index before do_build after do_install

LICENSE = MIT
