
import datetime
import time
import fcntl
import os
import signal
import traceback
import sys

def parse_timecert(value):
    return apply(datetime.datetime, time.strptime(value, "%Y-%m-%dT%H:%M:%S")[:6])

def set_nonblocking(fd):
	fl = fcntl.fcntl(fd, fcntl.F_GETFL)
	fcntl.fcntl(fd, fcntl.F_SETFL, fl | os.O_NDELAY)

def terminate_popen3(process):
        print >> sys.stderr, ("[%s] stopping process: %s" % (os.getpid(), process.pid))
        try:
            process.tochild.close()
            process.fromchild.close()
            process.childerr.close()
            if process.poll() == -1:
                # the process is still running, so kill it.
                os.kill(process.pid, signal.SIGKILL)
            process.wait()
        except:
            print >> sys.stderr, ("%s failed_to_stop %s (%s)" % (os.getpid(), process.pid, traceback.format_exc()))

def ago(event):
    def plural(v, singular, plural):
        if v == 1:
            return "%d %s" % (v, singular)
        else:
            return "%d %s" % (v, plural)
    now = datetime.datetime.utcnow()
    ago = now - event
    if ago.days > 0:
        rv = "%s" % (plural(ago.days, "day", "days"))
    elif ago.seconds > 3600:
        hours = ago.seconds / 3600
        minutes = (ago.seconds - (hours * 3600)) / 60
        rv = "%s" % (plural(hours, "hour", "hours"))
    else:
        minutes = ago.seconds / 60
        seconds = (ago.seconds - (minutes * 60))
        rv = "%s" % (plural(minutes, "minute", "minutes"))
    return rv

