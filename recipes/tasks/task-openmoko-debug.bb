DESCRIPTION = "Openmoko: Debugging and Benchmarking Tools"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r59.01"

inherit task

RDEPENDS_task-openmoko-debug = "\
  alsa-utils-amixer \
  alsa-utils-aplay \
  alsa-utils-aconnect \
  alsa-utils-alsamixer \
  alsa-utils-speakertest \
  bonnie++ \
  cu \
  dbench \
  fbgrab \
  fbset \
  fstests \
  gdb \
  gdbserver \
  lrzsz \
  lsof \
  ltrace \
  memtester \
#  sensors-i2cdetect sensors-i2cdump sensors-i2cset \
  strace \
  tcpdump \
  tslib-calibrate \
  tslib-tests \
  udev-utils \
  usbutils \
  uucp \
  vorbis-tools \
  x11perf \
  xev \
  ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'madplay', d)} \
"
