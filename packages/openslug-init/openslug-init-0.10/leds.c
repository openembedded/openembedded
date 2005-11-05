 #include <stdio.h>
 #include <stdlib.h>
 #include <math.h>
 #include <errno.h>
 #include <string.h>
 #include <endian.h>
 #include <unistd.h>
 #include <fcntl.h>
 #include <sys/ioctl.h>
 #include "leds.h"

 static int leds;
 static int reset;
 static int verbose = 0;
 enum {
   off=0, on=1, blink, unknown, transition=unknown
 };


 void init_leds(void)
 {
   int i;
   if ((leds = open("/dev/leds", O_RDWR)) < 0) {
     int e1 = errno;
     if (e1 != ENOENT) {

       fprintf(stderr,"Error: Could not open LEDS device file '/dev/leds' : %s\n",
               strerror(e1));
       if(e1 == EACCES)
         fprintf(stderr,"Run as root\n");
       exit(1);
     }
   }

   if (verbose)
     printf("leds: initialized.\n");
 }

 void led_ioctl( int cmd, int num )
 {
   int i, st;

   if (ioctl(leds, cmd, num) < 0) {
     int e1 = errno;
     fprintf(stderr, "leds: ioctl(%d,%d): failed to set leds: %s\n",
	 cmd, num, strerror(e1));
     exit(1);
   }
 }

 void led_set( int led, int state )
 {
   switch (state) {
   case off:   if (!reset) led_ioctl(N2_LM_OFF, led); break;
   case on:    led_ioctl(N2_LM_ON, led); break;
   case blink: /* Ensure any previous timer gets deleted first and that
		* the LED is in a well known state.
		*/
	       if (!reset) led_ioctl(N2_LM_OFF, led);
	       led_ioctl(N2_LM_BLINK, led); break;
   }
 }

 int led( int ch ) {
   switch (ch) {
   case 'r': return LED_RS_RED;
   case 'g': return LED_RS_GRN;
   case '1': return LED_DISK1;
   case '2': return LED_DISK2;
   case 'A': reset = 1; return LED_ALL;
   default:  fprintf(stderr, "leds: %c: unknown LED (use r,g,0,1 or A)\n", ch);
	     exit(1);
   }
 }

 int main( int argc, char **argv ) 
 {
	/* Default: switch green on, red off (-A +g). */
	if (argc == 1) {
	  verbose = 1;
	  init_leds();
	  led_ioctl(N2_LM_ALL_OFF, 0);
	  led_ioctl(N2_LM_ON, LED_RS_GRN);
	} else {
	  int i, alt=0, state[PHYS_LEDS];
	  for(i=0; i<PHYS_LEDS; ++i)
	    state[i] = unknown;
	  reset = 0;

	  while (--argc > 0) {
	    char *arg = *++argv;
	    int st;
	    if (strcmp(arg, "-v") == 0) {
	      ++verbose;
	      continue;
	    }

	    switch (*arg) {
	    case '+': st = on; break;
	    case '-': st = off; break;
	    case '!': st = blink; break;
	    case '/': st = transition; break;
	    default:  fprintf(stderr, "leds: %c: unknown option\n", *arg);
		      exit(1);
	    }

	    if (st != transition) {
	      while (*++arg) {
		i = led(*arg);
		if (i == LED_ALL)
		  for (i=0; i<PHYS_LEDS; ++i) state[i] = st;
		else
		  state[i] = st;
	      }
	    } else {
	      int done, newstate[PHYS_LEDS];
	      for(i=0; i<PHYS_LEDS; ++i)
		newstate[i] = off;
	      while (*++arg) {
		i = led(*arg);
		if (i == LED_ALL)
		  for (i=0; i<PHYS_LEDS; ++i) newstate[i] = on;
		else
		  newstate[i] = on;
	      }

	      /* Merge the newstate back in.  This sets 'alt' if going
	       * from an old state of just red to a new of just green
	       * or vice versa (and this is the only way of getting
	       * 'alt')
	       */
	      /* Blink anything which changes from off to on or from
	       * on to off (this ignores anything already blinking).
	       */
	      for (done=i=0; i<PHYS_LEDS; ++i) {
		if (state[i] == !newstate[i]) {
		  done = 1;
		  state[i] = blink;
		}
	      }

	      /* Is anything (new) blinking?  If it is then deal
	       * with the red/green case - blinking red,green is
	       * amber, is that what we want?  This could be
	       * improved by a better kernel interface - it would
	       * be nice just to specify on/off times and a start
	       * time for each LED.
	       */
	      if (done) {
		if (state[LED_RS_RED] == blink && state[LED_RS_GRN] == blink &&
		    newstate[LED_RS_RED] == !newstate[LED_RS_GRN]) {
		  /* Kernel bug: must switch off r and g first. */
		  alt = 1;
		}
	      } else {
		for (i=0; i<PHYS_LEDS; ++i) {
		  if (newstate[i] == on) {
		    state[i] = blink;
		  }
		}
	      }
	    }
	  }

	  /* Go through the list making the required settings.  'alt' is
	   * special.  'reset' means A was given and all the settings are
	   * known.
	   */
	  init_leds();
	  if (reset)
	    led_ioctl(N2_LM_ALL_OFF, 0);
	  if (alt) {
	    /* Turn the leds off first to get to a known state. */
	    led_set(LED_RS_GRN, off);
	    led_set(LED_RS_RED, off);
	    led_ioctl(N2_LM_ALT, LED_RS_RED);
	  } else {
	    /* KERNEL BUG: setting the green timer zaps the red behaviour
	     * to toggle the green, therefore if red blink is set before
	     * green blink no blink will happen!
	     */
	    led_set(LED_RS_GRN, state[LED_RS_GRN]);
	    led_set(LED_RS_RED, state[LED_RS_RED]);
	  }
	  led_set(LED_DISK1, state[LED_DISK1]);
	  led_set(LED_DISK2, state[LED_DISK2]);
	}

	return 0;
 }
