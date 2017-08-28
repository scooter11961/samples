//
//  HelloWorldCocoaAppDelegate.h
//  HelloWorldCocoa
//
//  Created by scotthatch07 on 4/23/10.
//  Copyright 2010 __MyCompanyName__. All rights reserved.
//

#import <Cocoa/Cocoa.h>

@interface HelloWorldCocoaAppDelegate : NSObject <NSApplicationDelegate> {
    NSWindow *window;
}

@property (assign) IBOutlet NSWindow *window;

@end
