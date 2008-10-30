#
# Hardware-based properties
#

TARGET_ARCH = "arm"

SERIAL_CONSOLE = "115200 ttyS0"

# Use tune-xscale per default. Machine independent feeds should be built with tune-strongarm.
require conf/machine/include/tune-xscale.inc

MACHINE_FEATURES = "kernel26 touchscreen apm alsa bluetooth irda usbgadget screen ext2 vfat"

#
# Software/packages selection
#

PREFERRED_PROVIDER_virtual/kernel = "linux-hackndev-2.6"

PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive"

module_autoload_sa1100-rtc = "sa1100-rtc"
module_autoload_snd-ac97-bus = "snd-ac97-bus"
module_autoload_apm_power = "apm_power"
module_autoload_backlight = "backlight"
module_autoload_battery = "battery"
module_autoload_bcm2035_uart = "bcm2035_uart"
module_autoload_gpioed = "gpioed"
module_autoload_gpioed-ng = "gpioed-ng"
module_autoload_lcd = "lcd"
module_autoload_led-class = "led-class"
module_autoload_leds-palmld = "leds-palmld"
module_autoload_ledtrig-heartbeat = "ledtrig-heartbeat"
module_autoload_ledtrig-hwtimer = "ledtrig-hwtimer"
module_autoload_ledtrig-timer = "ledtrig-timer"
module_autoload_palmld_battery = "palmld-battery"
module_autoload_palmld_ide = "palmld-ide"
module_autoload_palmld_pcmcia = "palmld-pcmcia"
module_autoload_pcmcia = "pcmcia"
module_autoload_pcmcia_core = "pcmcia-core"
module_autoload_pda_power = "pda_power"
module_autoload_pxa2xx_core = "pxa2xx-core"
module_autoload_snd = "snd"
module_autoload_snd-ac97-codec = "snd-ac97-codec"
module_autoload_snd-mixer-oss = "snd-mixer-oss"
module_autoload_snd-page-alloc = "snd-page-alloc"
module_autoload_snd-pcm = "snd-pcm"
module_autoload_snd-pcm-oss = "snd-pcm-oss"
module_autoload_snd-pxa2xx-pcm = "snd-pxa2xx-pcm"
module_autoload_snd-pxa2xx-ac97 = "snd-pxa2xx-ac97"
module_autoload_snd-seq = "snd-seq"
module_autoload_snd-seq-device = "snd-seq-device"
module_autoload_seq-midi-event = "seq-midi-event"
module_autoload_snd-seq-oss = "snd-seq-oss"
module_autoload_snd-timer = "snd-timer"
module_autoload_soundcore = "soundcore"
module_autoload_wm97xx-ts = "wm97xx-ts"
module_autoload_pxa27x-keyboard = "pxa27x-keyboard"
module_autoload_palmtx_battery = "palmtx_battery"
module_autoload_palmz72_battery = "palmz72_battery"
module_autoload_i2c-dev = "i2c-dev"
module_autoload_i2c-pxa = "i2c-pxa"


MACHINE_EXTRA_RRECOMMENDS = "\
	kernel-module-ac97-bus \
	kernel-module-apm-power \
	kernel-module-backlight \
	kernel-module-battery \
	kernel-module-led-class \
	kernel-module-lcd \
	kernel-module-gpioed \
	kernel-module-gpioed-ng \
	kernel-module-external-power \
	kernel-module-snd \
	kernel-module-snd-ac97-codec \
	kernel-module-snd-page-alloc \
	kernel-module-snd-pcm \
	kernel-module-snd-seq \
	kernel-module-snd-seq-device \
	kernel-module-snd-seq-midi-event \
	kernel-module-snd-seq-oss \
	kernel-module-snd-timer \
	kernel-module-soundcore \
	"
