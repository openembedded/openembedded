DESCRIPTION = "Meta package for Mamona"
LICENSE = "MIT"
PR = "r1"

inherit meta
EXCLUDE_FROM_WORLD = "1"

RDEPENDS = " \
task-mamona-base \
task-mamona \
task-mamona-devel \
task-mamona-sdk \
coreutils \
cpio \
dbus \
diffstat \
dnsmasq \
dosfstools \
e2fsprogs \
expat \
e-wm \
findutils \
fontconfig \
gconf \
glib-2.0 \
gnome-common \
gnome-vfs \
groff \
gstreamer \
gtk+ \
gtk+-doc \
gtk-engines-dev \
ifupdown \
initscripts \
intltool \
libart-lgpl \
libdbi \
libelf \
libfontenc \
libmatchbox \
liboil \
libpng \
libtelepathy \
libtool \
libusb \
libxau \
libxcursor \
libxdmcp \
libxext \
libxfixes \
libxfont \
libxi \
libxkbfile \
libxml2 \
libxpm \
libxrandr \
libxrender \
libxslt \
libxt \
libxtst \
libxv \
lsof \
makedev \
matchbox-wm \
mime-support \
module-init-tools \
mplayer-maemo \
ncurses \
net-tools \
netbase \
portmap \
ppp \
procps \
python-pyqt \
qt4-x11-free \
renderproto-dev \
samba \
sgml-common \
shared-mime-info \
slang \
sqlite \
sqlite3 \
sudo \
sysvinit \
telepathy-gabble \
telepathy-glib \
telepathy-mission-control \
tslib \
ttf-bitstream-vera \
udev \
util-linux \
wget \
xkbd \
xtrans-dev \
"

# TODO: some of noemu packages are broken. Fix them before
# put task-mamona-noemu back to meta-mamona.
#task-mamona-noemu \

include mamona-buildall.inc
