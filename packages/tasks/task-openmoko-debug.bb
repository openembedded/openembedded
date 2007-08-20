DESCRIPTION = "OpenMoko: Debugging Tools"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r57"

inherit task

RDEPENDS_task-openmoko-debug = "\
  alsa-utils-amixer \
  alsa-utils-aplay \
  alsa-utils-aconnect \
  alsa-utils-alsamixer \
  alsa-utils-speakertest \
  madplay \
  vorbis-tools \
  strace \
  ltrace \
  gdb \
  gdbserver \
  tcpdump \
  tslib-calibrate \
  tslib-tests \
  fbgrab \
  fstests \
  lsof \
  lrzsz \
  udev-utils \
  usbutils \
  uucp \
  cu \
#  sensors-i2cdetect sensors-i2cdump sensors-i2cset \
  xev \
  bonnie++ \
  memtester \
  dbench \
"
