require bug-app.inc

DESCRIPTION = "*R1.4 ONLY: Tested with bug-image-production-bug-20081231023422.rootfs.ext3 and zImage-2.6.27.2+svnr7773-bug-20081231020035 with BUGmotion in slot 0 and BUGaudio in slot 1.*\
Rewritten from scratch to use IAudioPlayer interface. The app now reads in 3 samples for each of the X, Y and Z axes at startup from its resource bundle. It then chooses between them at runtime based on the accelerometer input given to it via its update() method.\
The accelerometer readings determine which sample will be used for each axis and the chosen three are then 'mixed' and used as what's played.\
Thus by moving the BUGbase you can change the sound that's being played.\
The samples provided were generated in 'Hydrogen(Hydrogen)':http://www.hydrogen-music.org\
However, it's easy to replace them with your own if you like. If you look at the constructor for the SampleStream class you will see 9 lines loading in the existing samples, such as cowbell.raw. If you expand the Phunky application in Eclipse you will see a folder called resources. In there you will find the existing samples. Just put your own sample files in there, change SampleStream's constructor to load them instead of the default ones and redeploy the application to your BUG. \
Keep in mind that the BUG isn't a desktop computer, so you probably want to remove the existing samples before you redeploy, and you will want to keep your samples on the small side.\
The new samples should all be raw 44.1kHz 16-bit samples, stereo, little-endian. You can create a WAV file in that format and use something like sox to make it into a raw file ('sox foo.wav foo.raw' will do it).\
(BUGaudio supports other formats but the list wasn't available at the time of this writing.)\
"
HOMEPAGE = "http://buglabs.net/applications/Phunky"

DEPENDS += "com.buglabs.bug.jni.accelerometer com.buglabs.bug.module.motion com.buglabs.bug.module.audio com.buglabs.bug.audio.common com.buglabs.common com.buglabs.osgi service-tracker "

PV = "12"

SRC_LINK = "http://buglabs.net/program_version/download/595"

APIVERSION = ""
