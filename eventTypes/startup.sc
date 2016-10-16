TypeDef{
	*initClass{
		StartUp.add({

			var r;
			
			defer{
				var io=FlowView(bounds:Rect(800, 800, 300, 100));
				Server.default.makeGui(io);
				//	SynthDefPool.gui;
				io.parent.alwaysOnTop_(true);
			};

			// r=FlowView(bounds:100@100);
			// Button(r).states_([
			// 	["enclenché", Color.red],
			// 	["ta mère", Color.green]
			// ]).action_{
			// 	ProtoGui.push
			// };
			
			Event.addEventType(\appo,{ arg self;
				var dur, mtranspose;
				~degree=(~degree+~mtranspose).degreeToKey(~scale?[0,2,4],7);
				~scale=~mode ? #[0,2,4,5,7,9,11];
				~appo !? {
					if(~appo==0){dur=0}
					{
						mtranspose=Pseq(({[-1,1].choose}!~appo?1));
						dur=(~dur!(~appo)).normalizeSum * ~dur;
					}
				} ??
				{	dur=~dur.value			};
				~type=\note;
				Pbind(\dur, dur.pseq, \mtranspose, mtranspose?0)
				.play(protoEvent:currentEnvironment);
				//	~type=\note; currentEnvironment.play
			});
	
		})
	}
}