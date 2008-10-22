DESCRIPTION = "Necessary packages for Mamona run on Nokia Internet Tablets"
LICENSE = "MIT"
PR = "r0"
ALLOW_EMPTY = "1"

RDEPENDS = "\
  task-mamona \
  xmodmap \
  xdpyinfo \
  xtscal \
  wireless-tools \
  wpa-supplicant \
  bluez-utils \
  bluez-utils-compat \
  dspgw-utils \
  libasound-module-ctl-dsp-ctl \
  libasound-module-pcm-alsa-dsp \
  alsa-conf-base \
  alsa-utils-alsamixer \
  alsa-lib \
  alsa-utils-alsactl \
  alsa-state \
  mamona-sound-n800 \
  usbnet \
  openssh-sshd \
  openssh-scp \
"
