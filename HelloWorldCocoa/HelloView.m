//
//  HelloView.m
//  HelloWorldCocoa
//
//  Created by scotthatch07 on 4/23/10.
//  Copyright 2010 __MyCompanyName__. All rights reserved.
//

#import "HelloView.h"


@implementation HelloView

- (id)initWithFrame:(NSRect)frame {
    self = [super initWithFrame:frame];
    if (self) {
        // Initialization code here.
    }
    return self;
}

- (void)drawRect:(NSRect)dirtyRect {
    NSString* hello = @"Hello, Happy World!";
	NSPoint point = NSMakePoint(15, 75);
	NSMutableDictionary* font_attributes = [NSMutableDictionary new];
    NSFont* font = [NSFont fontWithName:@"Futura-MediumItalic" size:42];
    [font_attributes setObject:font forKey:NSFontAttributeName];
	
    [hello drawAtPoint:point withAttributes:font_attributes];
	
    [font_attributes release];
}

@end
