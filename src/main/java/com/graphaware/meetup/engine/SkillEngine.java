package com.graphaware.meetup.engine;

import com.graphaware.reco.generic.context.Context;
import com.graphaware.reco.generic.engine.SingleScoreRecommendationEngine;
import com.graphaware.reco.generic.transform.ParetoScoreTransformer;
import com.graphaware.reco.generic.transform.ScoreTransformer;
import com.graphaware.reco.neo4j.engine.SomethingInCommon;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.tooling.GlobalGraphOperations;

import javax.management.relation.RelationType;
import java.util.HashMap;
import java.util.Map;

/**
 * A very stupid engine, just recommends the fist X nodes, where X is the requested limit.
 */
public class SkillEngine extends SomethingInCommon {

//    @Override
//    protected Map<Node, Float> doRecommendSingle(Node input, Context<Node, Node> context) {
//        Map<Node, Float> result = new HashMap<>();
//
//        for (Node node : GlobalGraphOperations.at(input.getGraphDatabase()).getAllNodes()) {
//            addToResult(result, node, (float) Math.random());
//
//            if (context.limit() <= result.size()) {
//                break;
//            }
//        }
//
//        return result;
//    }

    @Override
    public String name() {
        return "SkillScore";
    }

    @Override
    protected RelationshipType getType() {
        return DynamicRelationshipType.withName("HAS");
    }

    @Override
    protected Direction getDirection() {
        return Direction.BOTH;
    }

    @Override
    protected ScoreTransformer scoreTransformer() {
        return new ParetoScoreTransformer(100,4);
    }
}
